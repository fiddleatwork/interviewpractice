package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.pow


class Leet011ContainerMostWater {

    @Test
    fun `example 1`() {
        assertThat(listOf(1, 8, 6, 2, 5, 4, 8, 3, 7).mostWater()).isEqualTo(49)
    }

    @Test
    fun `example 2`() {
        assertThat(listOf(1, 1).mostWater()).isEqualTo(1)
    }

    @Test
    fun `big test`() {
        assertThat(
            listOf(
                581,
                3745,
                6054,
                3209,
                3471,
                7281,
                2558,
                2350,
                5695,
                7485,
                4767,
                2942,
                9950,
                8502,
                9406,
                6627
            ).mostWater()
        ).isEqualTo(78702)
    }

    fun maxArea(height: IntArray): Int {
        return height.toList().mostWater()
    }

    private fun List<Int>.mostWater(): Int {
        var left = 0
        var right = size - 1
        var max = 0
        do {
            max = Math.max((right - left) * Math.min(this[left], this[right]), max)
            if (this[left] < this[right]) {
                left++
            } else {
                right--
            }
        } while (left != right)
        return max
    }

    private fun List<Int>.mostWater2(): Int {
        val results = mutableMapOf<Pair<Int, Int>, Int>()
        var maxResult = 0
        for (i in 0 until size) {
            for (j in i until size) {
                val result = (j - i) * Math.min(this[i], this[j])
                if (result > maxResult) {
                    maxResult = result
                }
            }
        }
        return maxResult
    }

}