package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class Leet009PalindromeNumber {

    @Test
    fun `test case 1`() {
        assertThat(
            isPalindrome(121)
        ).isEqualTo(true)
    }

    @Test
    fun `test case 2`() {
        assertThat(
            isPalindrome(-121)
        ).isEqualTo(false)
    }

    @Test
    fun `test case 3`() {
        assertThat(
            isPalindrome(-10)
        ).isEqualTo(false)
    }

    fun isPalindrome(x: Int): Boolean {
        return x.toString() == x.toString().reversed()
    }

}