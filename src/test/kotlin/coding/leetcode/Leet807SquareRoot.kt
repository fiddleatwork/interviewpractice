package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.math.min

class Leet807SquareRoot {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        val maxIncreaseTopBottom = Array(grid.size) { IntArray(grid.size) { 0 } }
        val maxIncreaseSideToSide = Array(grid.size) { IntArray(grid.size) { 0 } }
        val maxIncrease = Array(grid.size) { IntArray(grid.size) { 0 } }

        grid.indices.forEach { column ->
            var columnMax = 0
            grid.indices.forEach { row ->
                columnMax = max(columnMax, grid[row][column])
            }
            grid.indices.forEach { row ->
                maxIncreaseTopBottom[row][column] = columnMax - grid[row][column]
            }
        }

        grid.indices.forEach { row ->
            var rowMax = 0
            grid.indices.forEach { column ->
                rowMax = max(rowMax, grid[row][column])
            }
            grid.indices.forEach { column ->
                maxIncreaseSideToSide[row][column] = rowMax - grid[row][column]
            }
        }

        println("maxIncreaseTopBottom: \n${maxIncreaseTopBottom.asString()}")
        println("maxIncreaseSidetoSide: \n${maxIncreaseSideToSide.asString()}")

        var totalIncrease = 0
        grid.indices.forEach { row ->
            grid.indices.forEach { column ->
                maxIncrease[row][column] = min(maxIncreaseTopBottom[row][column], maxIncreaseSideToSide[row][column])
                totalIncrease += maxIncrease[row][column]
            }
        }

        println("maxIncrease: \n${maxIncrease.asString()}")

        return totalIncrease
    }

    fun Array<IntArray>.asString(): String {
        var s = ""
        indices.forEach { row ->
            indices.forEach { column ->
                s += this[row][column].toString() + " "
            }
            s += "\n"
        }
        return s
    }

    @Test
    fun `example 1`() {
        val grid = arrayOf(
            intArrayOf(3, 0, 8, 4),
            intArrayOf(2, 4, 5, 7),
            intArrayOf(9, 2, 6, 3),
            intArrayOf(0, 3, 1, 0),
        )
        assertThat(maxIncreaseKeepingSkyline(grid)).isEqualTo(35)
    }

    @Test
    fun `test case 103`() {
        val grid = arrayOf(
            intArrayOf(13, 47, 91, 34, 20, 33, 39, 22, 80, 62),
            intArrayOf(73, 97, 88, 51, 38, 36, 52, 75, 25, 99),
            intArrayOf(95, 43, 32, 26, 82, 74, 60, 69, 59, 55),
            intArrayOf(20, 41, 77, 95, 79, 46, 70, 50, 17, 51),
            intArrayOf(51, 0, 93, 27, 46, 41, 58, 49, 8, 5),
            intArrayOf(92, 58, 38, 56, 73, 93, 34, 47, 23, 62),
            intArrayOf(97, 66, 57, 72, 26, 46, 4, 90, 82, 74),
            intArrayOf(7, 44, 67, 96, 0, 82, 75, 22, 53, 100),
            intArrayOf(95, 48, 46, 68, 41, 53, 69, 42, 13, 87),
            intArrayOf(79, 48, 96, 39, 21, 35, 3, 12, 22, 42),
        )
        assertThat(maxIncreaseKeepingSkyline(grid)).isEqualTo(3673)
    }

}