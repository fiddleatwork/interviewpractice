package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class Leet001TwoSum {

    @Test
    fun `test case 1`() {
        assertThat(
            twoSum(intArrayOf(2, 7, 11, 15), 9)
        ).isEqualTo(intArrayOf(0, 1))
    }

    fun twoSumBrute(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { i, m ->
            nums.forEachIndexed { j, n ->
                if (i != j && m + n == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val lookupTable = nums.mapIndexed { i, n ->
            target - n to i
        }.toMap()
        nums.forEachIndexed { i, n ->
            val m = lookupTable[n]
            if(m != null && m != i) {
                return intArrayOf(i, m)
            }
        }
        return intArrayOf()
    }


}