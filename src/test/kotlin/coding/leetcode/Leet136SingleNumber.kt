package coding.leetcode

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class Leet136SingleNumber {
    private fun singleNumber(nums: IntArray): Int {
        val foundMap = mutableMapOf<Int, Int>()
        nums.forEachIndexed { i, n ->
            if (foundMap.containsKey(n)) {
                foundMap.remove(n)
            } else {
                foundMap[n] = i
            }
        }
        return foundMap.keys.first()
    }

    @Test
    fun examples() {
        assertThat(singleNumber(arrayOf(2, 2, 1).toIntArray())).isEqualTo(1)
        assertThat(singleNumber(arrayOf(4, 1, 2, 1, 2).toIntArray())).isEqualTo(4)
        assertThat(singleNumber(arrayOf(1).toIntArray())).isEqualTo(1)
    }

}