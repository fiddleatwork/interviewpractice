package coding.hackerrank.week1prep.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RecursiveDigitSum {

    @Test
    fun `test case 0`() {
        assertThat(
            superDigit("148", 3)
        ).isEqualTo(3)
    }

    @Test
    fun `test case 11`() {
        assertThat(
            superDigit("123", 3)
        ).isEqualTo(9)
    }

    @Test
    fun `example test case`() {
        assertThat(
            superDigit("9875", 4)
        ).isEqualTo(8)
    }

    @Test
    fun `super digit of a single digit is the digit`() {
        assertThat(
            superDigit("8", 1)
        ).isEqualTo(8)
    }

    @Test
    fun `super digit of 9875`() {
        assertThat(
            superDigit("9875", 1)
        ).isEqualTo(2)
    }

    @Test
    fun `convert digit from string to int`() {
        assertThat(
            '9'.myDigitToInt()
        ).isEqualTo(9)
    }

    // Hackerrank is Kotlin 1.3 :(
    private fun Char.myDigitToInt() = code - '0'.code

    private tailrec fun superDigit(n: String): Int {
        if (n.length == 1) {
            return n.toInt()
        }
        return superDigit(
            n.toCharArray()
                .map { it.myDigitToInt() }
                .sum()
                .toString()
        )
    }

    private fun superDigit(n: String, k: Int): Int {
        return superDigit((superDigit(n) * k).toString())
    }
}

