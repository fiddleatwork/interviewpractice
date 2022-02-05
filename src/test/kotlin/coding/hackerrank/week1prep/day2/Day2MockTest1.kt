package coding.hackerrank.week1prep.day2

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * I didn't complete the test within the time alloted (24 minutes) and no longer have access to the
 * test page so I can't see the details of the question.  I'm setting this aside for now.
 */
class Day2MockTest1 {

    @Test
    fun `test case 1`() {
        Assertions.assertThat(
            flippingMatrix(
                arrayOf(
                    arrayOf(1, 2),
                    arrayOf(3, 4),
                )
            )
        ).isEqualTo(4)
    }

    @Test
    fun `test case 2`() {
        assertThat(
            flippingMatrix(
                arrayOf(
                    arrayOf(112, 42, 83, 119),
                    arrayOf(56, 125, 56, 49),
                    arrayOf(15, 78, 101, 43),
                    arrayOf(62, 98, 114, 108),
                )
            )
        ).isEqualTo(414)
    }

    @Test
    fun `sum upper left quandrant`() {
        // results after flipping rows
        // 83 119 112 42 flipped
        // 56 125 56 49
        // 101 43 15 78 flipped
        // 114 108 62 98 flipped
        // after flipping columns
        // 101 43 112 78
        // 114 108 56 98
        // 83 119 15 42
        // 56 125 62 49
        assertThat(
            arrayOf(
                arrayOf(112, 42, 83, 119),
                arrayOf(56, 125, 56, 49),
                arrayOf(15, 78, 101, 43),
                arrayOf(62, 98, 114, 108),
            ).sumUpperLeftQuadrant()
        ).isEqualTo(335)
    }

    @Test
    fun `split into two`() {
        val split = arrayOf(112, 42, 83, 119).splitIntoTwo()
            .also {
                println(it.toList())
            }
        assertThat(split.first).contains(112, 42)
        assertThat(split.second).contains(83, 119)
    }

    @Test
    fun `transpose`() {
        val original = arrayOf(
            arrayOf(1, 2),
            arrayOf(3, 4),
        )
        original.transpose()
        assertThat(original).isDeepEqualTo(
            arrayOf(
                arrayOf(1, 3),
                arrayOf(2, 4),
            )
        )
    }

    fun Array<Array<Int>>.sumUpperLeftQuadrant() =
        sliceArray(0 until size / 2)
            .map { it.sliceArray(0 until size / 2) }
            .map { it.sum() }
            .sum()

    fun Array<Int>.splitIntoTwo() =
        Pair(sliceArray(0 until size / 2), sliceArray(size / 2 until size))

    fun Array<Array<Int>>.toPrettyString(): String {
        return map { a -> a.joinToString(",") { "$it" } }.joinToString("\n") { "$it" }
    }

    private fun Array<Array<Int>>.deepCopyOf(): Array<Array<Int>> =
        map { a -> a.map { it }.toTypedArray() }.toTypedArray()

    private fun Array<Array<Int>>.transpose(): Array<Array<Int>> {
        for (i in indices) {
            for (j in i + 1 until size) {
                val temp = this[i][j]
                this[i][j] = this[j][i]
                this[j][i] = temp
            }
        }
        return this
    }

    fun flippingMatrix(matrix: Array<Array<Int>>): Int {
        for (i in matrix.indices) {
            val (a, b) = matrix[i].splitIntoTwo()
            if (b.sum() > a.sum()) {
                matrix[i] = matrix[i].reversed().toTypedArray()
            }
        }

        // I think transposing isn't a valid operation and this is making the result false
        matrix.transpose()
        for (i in matrix.indices) {
            val (a, b) = matrix[i].splitIntoTwo()
            if (b.sum() > a.sum()) {
                matrix[i] = matrix[i].reversed().toTypedArray()
            }
        }

        println(matrix.toPrettyString())
        return matrix.sumUpperLeftQuadrant()
    }
}