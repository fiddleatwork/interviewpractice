package coding.educative.patterns.fastslowpointers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.math.pow


class HappyNumber {

    private fun Int.happyNumber(): Boolean {
        val map = mutableMapOf<Int, Int>()
        var n = this
        while (n != 1) {
            if (map.contains(n)) {
                return false
            }
            val sumOfSquaresOfDigits = n.sumOfSquaresOfDigits()
            map[n] = sumOfSquaresOfDigits
            n = sumOfSquaresOfDigits

        }
        return true
    }

    fun Int.sumOfSquaresOfDigits(): Int =
        toString()
            .toCharArray()
            .sumOf {
                (it.code - '0'.code) * (it.code - '0'.code)
            }

    @CsvSource(
        value = [
            "23, true",
            "12, false",
        ]
    )
    @ParameterizedTest
    fun test(n: Int, expected: Boolean) {
        assertThat(n.happyNumber()).isEqualTo(expected)
    }

    @Test
    fun testSumOfSquaresOfDigits() {
        assertThat(25.sumOfSquaresOfDigits()).isEqualTo(29)
    }
}