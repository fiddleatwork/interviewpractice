package coding.leetcode

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.pow

class Leet283MoveZeros {

    private fun IntArray.nextNonZeroIndex(i: Int): Int =
        toList().subList(i + 1, size).indexOfFirst { n -> n != 0 } + (i+1)

    private fun moveZeroes(nums: IntArray) {
        if (nums.size < 2) {
            return
        }
        (0..<nums.size - 1).forEach { i ->
            if (nums[i] == 0) {
                val indexToSwap = nums.nextNonZeroIndex(i)
                val temp = nums[i]
                nums[i] = nums[indexToSwap]
                nums[indexToSwap] = temp
            }
        }
    }

    // 0,1,0,3,12
    // 1,0,0,3,12
    // 1,0,3,0,12
    // 1,0,3,12,0
    @Test
    fun example1() {
        val nums = intArrayOf(0, 1, 0, 3, 12)
        moveZeroes(nums)
        assertThat(nums).isEqualTo(intArrayOf(1, 3, 12, 0, 0))
    }

    @Test
    fun example2() {
        val nums = intArrayOf(0)
        moveZeroes(nums)
        assertThat(nums).isEqualTo(intArrayOf(0))
    }

    @Test
    fun test01() {
        val nums = intArrayOf(0, 1)
        moveZeroes(nums)
        assertThat(nums).isEqualTo(intArrayOf(1, 0))
    }

    @Test
    fun `should get index of next non-zero element`() {
        assertThat(intArrayOf(1, 0, 0, 3, 12).nextNonZeroIndex(0)).isEqualTo(3)
        assertThat(intArrayOf(1, 2, 3, 0, 12).nextNonZeroIndex(2)).isEqualTo(4)
    }


}