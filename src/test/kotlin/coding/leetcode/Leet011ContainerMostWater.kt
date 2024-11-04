package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.min


class Leet011ContainerMostWater {

    @Test
    fun `example 1`() {
        assertThat(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))).isEqualTo(49)
    }

    @Test
    fun `example 2`() {
        assertThat(maxArea(intArrayOf(1, 1))).isEqualTo(1)
    }

    private fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var max = 0
        do {
            max = Math.max((right - left) * Math.min(height[left], height[right]), max)
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        } while (left != right)
        return max
    }

    private fun List<Int>.mostWaterBruteForce(): Int {
        var maxResult = 0
        for (i in indices) {
            for (j in i until size) {
                val result = (j - i) * min(this[i], this[j])
                if (result > maxResult) {
                    maxResult = result
                }
            }
        }
        return maxResult
    }

}