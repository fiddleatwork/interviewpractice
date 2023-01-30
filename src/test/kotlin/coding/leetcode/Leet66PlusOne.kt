package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet66PlusOne {

        fun plusOne(digits: IntArray): IntArray {
            // [1,9,9]
            var n = digits.size-1
            while(n >= 0) {
                if (digits[n] < 9) {
                    digits[n] = digits[n] + 1
                    return digits
                }
                digits[n] = 0
                n -= 1
            }
            return intArrayOf(1) + digits
        }

    @Test
    fun `example 2`() {
        assertThat(plusOne(intArrayOf(4,3,2,1))).isEqualTo(intArrayOf(4,3,2,2))
    }

    @Test
    fun `example 3`() {
        assertThat(plusOne(intArrayOf(9))).isEqualTo(intArrayOf(1,0))
    }

    @Test
    fun `my example`() {
        assertThat(plusOne(intArrayOf(1,9,9))).isEqualTo(intArrayOf(2,0,0))
    }
}