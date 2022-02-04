package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.abs

class DiagonalDifference {

    @Test
    fun `calculate diagonal 1`() {
        assertThat(
            diagonalDifference(
                arrayOf(
                    arrayOf(1, 2, 3),
                    arrayOf(4, 5, 6),
                    arrayOf(9, 8, 9),
                )
            )
        ).isEqualTo(2)
    }

    @Test
    fun `calculate diagonal 2`() {
        assertThat(
            diagonalDifference(
                arrayOf(
                    arrayOf(11, 2, 4),
                    arrayOf(4, 5, 6),
                    arrayOf(10, 8, -12),
                )
            )
        ).isEqualTo(15)
    }

    @Test
    fun `calculate diagonal 4x4`() {
        assertThat(
            diagonalDifference(
                arrayOf(
                    arrayOf(1, 2, 3, 4),
                    arrayOf(5, 6, 9, 8),
                    arrayOf(10, 11, 12, 13),
                    arrayOf(8, 3, 1, 5),
                )
            )
        ).isEqualTo(abs(24 - 32))
    }

    fun diagonalDifference(arr: Array<Array<Int>>) =
        arr.mapIndexed{ i, t ->
            Pair(t[i],t.reversed()[i])
        }.let {d ->
            // Hackerrank only has Kotlin 1.3 so can't use sumOf
            abs(d.map { it.first }.sum() - d.map{it.second}.sum())
        }


}

