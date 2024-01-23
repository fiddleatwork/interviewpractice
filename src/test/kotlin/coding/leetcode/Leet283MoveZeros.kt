package coding.leetcode

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.pow

class Leet283MoveZeros {

    fun moveZeroes(nums: IntArray) {
        if(nums.size < 2) {
            return
        }
        var swapped = false
        (0..<nums.size-1).forEach { i ->
            if(nums[i] == 0 && nums[i+1] != 0) {
                val temp = nums[i]
                nums[i] = nums[i+1]
                nums[i+1] = temp
                swapped = true
            }
        }
        if(swapped) {
            moveZeroes(nums)
        }
    }

    // 0,1,0,3,12
    // 1,0,0,3,12
    // 1,0,3,0,12
    // 1,3,0,0,12
    // 1,3,0,12,0
    // 1,3,12,0,0
    @Test
    fun example1() {
        val nums = intArrayOf(0, 1, 0, 3, 12)
        moveZeroes(nums)
        assertThat(nums).isEqualTo(intArrayOf(1,3,12,0,0))
    }

    @Test
    fun example2() {
        val nums = intArrayOf(0)
        moveZeroes(nums)
        assertThat(nums).isEqualTo(intArrayOf(0))
    }

    @Test
    fun test01() {
        val nums = intArrayOf(0,1)
        moveZeroes(nums)
        assertThat(nums).isEqualTo(intArrayOf(1,0))
    }


}