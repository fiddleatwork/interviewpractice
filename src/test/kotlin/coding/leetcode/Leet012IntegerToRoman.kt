package coding.leetcode

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class Leet012IntegerToRoman {
    fun intToRoman(num: Int): String {
        val lookupTable = sortedMapOf(
                1 to "I",
                4 to "IV",
                5 to "V",
                9 to "IX",
                10 to "X",
                40 to "XL",
                50 to "L",
                90 to "XC",
                100 to "C",
                400 to "CD",
                500 to "D",
                900 to "CM",
                1000 to "M",
        )
        var n = num
        var result = ""
        while(n > 0) {
            val key = lookupTable.keys.last { it <= n }
            result += lookupTable[key]!!
            n -= key
        }
        return result
    }

    @Test
    fun myExample1() {
        assertThat(
                intToRoman(38)
        ).isEqualTo("XXXVIII")
    }

    @Test
    fun example2() {
        assertThat(
                intToRoman(58)
        ).isEqualTo("LVIII")
    }

    @Test
    fun example3() {
        assertThat(
                intToRoman(1994)
        ).isEqualTo("MCMXCIV")
    }
}