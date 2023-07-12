package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class Leet013RomanToInteger {

    @Test
    fun `example 1`() {
        assertThat(romanToInt("III")).isEqualTo(3)
    }

    @Test
    fun `example 2`() {
        assertThat(romanToInt("LVIII")).isEqualTo(58)
    }

    @Test
    fun `example 3`() {
        assertThat(romanToInt("MCMXCIV")).isEqualTo(1994)
    }

    private fun romanToInt(s: String): Int {

        var i = 0
        var result = 0

        fun increment(amount: Int, counterIncrement: Int) {
            result += amount
            i += counterIncrement
        }

        while (i < s.length) {
            val sub2 = if (i < s.length - 1) {
                s.substring(i..(i + 1))
            } else {
                ""
            }
            //println("Checking $i $sub2")
            when (sub2) {
                "IV" -> increment(4, 2)
                "IX" -> increment(9, 2)
                "XL" -> increment(40, 2)
                "XC" -> increment(90, 2)
                "CD" -> increment(400, 2)
                "CM" -> increment(900, 2)
                else -> when (s.substring(i..(i + 0))) {
                    "I" -> increment(1, 1)
                    "V" -> increment(5, 1)
                    "X" -> increment(10, 1)
                    "L" -> increment(50, 1)
                    "C" -> increment(100, 1)
                    "D" -> increment(500, 1)
                    "M" -> increment(1000, 1)
                    else -> error("Unrecognized symbol $sub2")
                }
            }
        }
        return result
    }
}