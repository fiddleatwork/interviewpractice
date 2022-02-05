package coding.hackerrank.week1prep.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * I have three algorithms.
 * RandomSteps makes a random reversal and does this n times, and it sometimes find the optimal solution.
 * FullAlgo doesn't find the optimal solution because it does rows then columns and to be optimal it has to be a mix of these.
 * And then the optimal which uses a pattern to determine the max sum.
 */
class Day2MockTestFlippingTheMatrix {

    @Test
    fun `test case 1`() {
        assertThat(
            flippingMatrix(
                arrayOf(
                    arrayOf(1, 2),
                    arrayOf(3, 4),
                )
            )
        ).isEqualTo(4)
    }

    private val test2Matrix = arrayOf(
        arrayOf(112, 42, 83, 119),
        arrayOf(56, 125, 56, 49),
        arrayOf(15, 78, 101, 43),
        arrayOf(62, 98, 114, 108),
    )

    @Test
    fun `test case 2`() {
        assertThat(
            flippingMatrixRandomSteps(
                test2Matrix
            )
        ).isEqualTo(414)
    }

    @Test
    fun `sum upper left quandrant`() {
        assertThat(test2Matrix.sumUpperLeftQuadrant()).isEqualTo(335)
    }

    @Test
    fun `calculate two sums of row`() {
        assertThat(test2Matrix.twoSumsOfRow(1)).isEqualTo(Pair(181, 105))
    }

    @Test
    fun `calculate two sums of column`() {
        assertThat(test2Matrix.twoSumsOfColumn(1)).isEqualTo(Pair(167, 176))
    }

    @Test
    fun `should reverse row`() {
        val array = arrayOf(
            arrayOf(10, 11, 12, 13),
            arrayOf(14, 15, 16, 17),
            arrayOf(18, 19, 20, 21),
            arrayOf(22, 23, 24, 25),
        )
        print(array.toPrettyString())
        array.reverseRow(1)
        print(array.toPrettyString())
        assertThat(array).isDeepEqualTo(
            arrayOf(
                arrayOf(10, 11, 12, 13),
                arrayOf(17, 16, 15, 14),
                arrayOf(18, 19, 20, 21),
                arrayOf(22, 23, 24, 25),
            )
        )
    }

    @Test
    fun `should reverse column`() {
        val array = arrayOf(
            arrayOf(10, 11, 12, 13),
            arrayOf(14, 15, 16, 17),
            arrayOf(18, 19, 20, 21),
            arrayOf(22, 23, 24, 25),
        )
        print(array.toPrettyString())
        array.reverseColumn(1)
        print(array.toPrettyString())
        assertThat(array).isDeepEqualTo(
            arrayOf(
                arrayOf(10, 23, 12, 13),
                arrayOf(14, 19, 16, 17),
                arrayOf(18, 15, 20, 21),
                arrayOf(22, 11, 24, 25),
            )
        )
    }

    private fun Array<Array<Int>>.sumUpperLeftQuadrant() =
        sliceArray(0 until size / 2)
            .map { it.sliceArray(0 until size / 2) }
            // Can't use sumOf because Hackerrank is only Kotlin 1.3 :(
            .map { it.sum() }
            .sum()

    private fun Array<Array<Int>>.twoSumsOfRow(r: Int): Pair<Int, Int> =
        Pair(this[r].sliceArray(0 until size / 2).sum(), this[r].sliceArray(size / 2 until size).sum())

    private fun Array<Array<Int>>.twoSumsOfColumn(c: Int): Pair<Int, Int> {
        // 1 2 3 4
        // 5 6 7 8
        // 9 1 2 3
        // 4 5 6 7
        var sumA = 0
        for (i in 0 until size / 2) {
            sumA += this[i][c]
        }
        var sumB = 0
        for (i in size / 2 until size) {
            sumB += this[i][c]
        }
        return Pair(sumA, sumB)
    }

    private fun Array<Array<Int>>.toPrettyString(): String {
        return map { a -> a.joinToString(",") { "$it" } }.joinToString("\n") { it } + "\n"
    }

    private fun Array<Array<Int>>.reverseRow(r: Int) {
        // 1 2 3 4
        // 5 6 7 8
        // 9 1 2 3
        // 4 5 6 7
        for (i in 0 until size / 2) {
            val temp = this[r][i]
            this[r][i] = this[r][size - 1 - i]
            this[r][size - 1 - i] = temp
        }
    }

    private fun Array<Array<Int>>.reverseColumn(c: Int) {
        // 1 2 3 4
        // 5 6 7 8
        // 9 1 2 3
        // 4 5 6 7
        for (i in 0 until size / 2) {
            val temp = this[i][c]
            this[i][c] = this[size - 1 - i][c]
            this[size - 1 - i][c] = temp
        }
    }

    private fun flippingMatrixRandomSteps(matrix: Array<Array<Int>>): Int {
        println("Starting matrix:\n" + matrix.toPrettyString())
        //var maxSum = 0
        repeat(1000000) {
            val i = (matrix.indices).random()
            if ((0..1).random() == 0) {
                val (a, b) = matrix.twoSumsOfRow(i)
                if (b > a) {
                    matrix.reverseRow(i)
                    println("\nFlipped row $i:\n" + matrix.toPrettyString())
                }
            } else {
                val (a, b) = matrix.twoSumsOfColumn(i)
                if (b > a) {
                    matrix.reverseColumn(i)
                    println("\nFlipped column $i:\n" + matrix.toPrettyString())
                }
            }
            //maxSum = max(maxSum, matrix.sumUpperLeftQuadrant())
        }
        return matrix.sumUpperLeftQuadrant()
    }

    private fun flippingMatrixFullAlgo(matrix: Array<Array<Int>>): Int {
        println("Starting matrix:\n" + matrix.toPrettyString())
        for (i in matrix.indices) {
            val (a, b) = matrix.twoSumsOfRow(i)
            if (b > a) {
                matrix.reverseRow(i)
                println("\nFlipped row $i:\n" + matrix.toPrettyString())
                break
            }
        }
        for (i in matrix.indices) {
            val (a, b) = matrix.twoSumsOfColumn(i)
            if (b > a) {
                matrix.reverseColumn(i)
                println("\nFlipped column $i:\n" + matrix.toPrettyString())
                break
            }
        }
        println("\nFinal:\n" + matrix.toPrettyString())
        return matrix.sumUpperLeftQuadrant()
    }

    private fun flippingMatrix(matrix: Array<Array<Int>>): Int {
        var sum = 0
        for (i in 0 until matrix.size / 2) {
            for (j in 0 until matrix.size / 2) {
                sum += listOf(
                    matrix[i][j],
                    matrix[i][matrix.size - 1 - j],
                    matrix[matrix.size - 1 - i][j],
                    matrix[matrix.size - 1 - i][matrix.size - 1 - j]
                ).maxOrNull()!!
            }
        }
        return sum
    }

}