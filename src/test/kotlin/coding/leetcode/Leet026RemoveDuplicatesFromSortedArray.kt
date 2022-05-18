package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet026RemoveDuplicatesFromSortedArray {

    companion object {

        private val IntArray.csv: String
            get() = joinToString(",")

        fun removeDuplicates2(nums: IntArray): Int {
            var j = 1
            for (i in 0 until nums.size - 1) {
                println("i=$i nums=${nums.csv}")
                if (nums[i] != nums[i + 1]) {
                    nums[j] = nums[i + 1]
                    j++
                }
            }
            println("FINAL nums=${nums.csv}")
            return j
        }
    }

    @Test
    fun `example2`() {
        val nums = intArrayOf(
            0, 0, 1, 1, 1, 2, 2, 3, 3, 4
        )
        assertThat(
            removeDuplicates2(
                nums
            )
        ).isEqualTo(5)
        assertThat(nums).isEqualTo(
            intArrayOf(
                0, 1, 2, 3, 4, 2, 2, 3, 3, 4
            )
        )
    }

    @Test
    fun `example1`() {
        val nums = intArrayOf(
            1, 1, 2
        )
        assertThat(
            removeDuplicates2(
                nums
            )
        ).isEqualTo(2)
        assertThat(nums).isEqualTo(
            intArrayOf(
                1, 2, 2
            )
        )
    }

    @Test
    fun `case 1`() {
        val nums = intArrayOf(
            1
        )
        assertThat(
            removeDuplicates2(
                nums
            )
        ).isEqualTo(1)
        assertThat(nums).isEqualTo(
            intArrayOf(
                1
            )
        )
    }

    @Test
    fun `case 1 2`() {
        val nums = intArrayOf(
            1, 2
        )
        assertThat(
            removeDuplicates2(
                nums
            )
        ).isEqualTo(2)
        assertThat(nums).isEqualTo(
            intArrayOf(
                1, 2
            )
        )
    }

    @Test
    fun `case 1 1 1 2`() {
        val nums = intArrayOf(
            1, 1, 1, 2
        )
        assertThat(
            removeDuplicates2(
                nums
            )
        ).isEqualTo(2)
        assertThat(nums).isEqualTo(
            intArrayOf(
                1, 2, 1, 2
            )
        )
    }
}

