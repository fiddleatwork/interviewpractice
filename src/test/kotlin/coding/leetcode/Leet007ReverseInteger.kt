package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.pow


class Leet007ReverseInteger {

    @Test
    fun `test case 1`() {
        assertThat(
            reverse(123)
        ).isEqualTo(321)
    }

    @Test
    fun `test case 2`() {
        assertThat(
            reverse(-123)
        ).isEqualTo(-321)
    }

    @Test
    fun `test case 3`() {
        assertThat(
            reverse(120)
        ).isEqualTo(21)
    }

    @Test
    fun `test case 4`() {
        assertThat(
            reverse(0)
        ).isEqualTo(0)
    }

    @Test
    fun `test case 5`() {
        assertThat(
            reverse(123456789)
        ).isEqualTo(987654321)
    }

    @Test
    fun `test case go over limit`() {
        assertThat(
            reverse(2147483647)
        ).isEqualTo(0)
    }

    private fun reverse(x: Int): Int {
        return try {
            abs(x)
                .toString()
                .reversed()
                .toInt() * if (x < 0) -1 else 1
        } catch (e: Exception) {
            0
        }
    }

}