package coding.hackerrank.week1prep.day3

import kotlin.Throws
import kotlin.jvm.JvmStatic
import coding.hackerrank.week1prep.day3.ZigZagSequence
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.lang.Exception
import java.util.*

class PalidromeIndex {
    @Test
    fun testCase0() {
        assertThat(palindromeIndex("bcbc")).isEqualTo(0)
        assertThat(palindromeIndex("aaa")).isEqualTo(-1)
    }

    val String.isPalindrome: Boolean
        get() = this == reversed()

    fun palindromeIndex(s: String): Int {
        if (s.isPalindrome) {
            return -1
        } else {
            // abccba
            // abcba
            (0..s.length / 2 - if (s.length % 2 == 0) 1 else 0).forEach { i ->
                val j = s.length - 1 - i
                if (s[i] != s[j]) {
                    if (s.removeRange(i..i).isPalindrome) {
                        return i
                    }
                    if (s.removeRange(j..j).isPalindrome) {
                        return j
                    }
                }
            }
            return -1
        }
    }

    fun palindromeIndexSlow(s: String): Int =
        if (s.isPalindrome) {
            -1
        } else {
            s.indices
                .asSequence()
                .map { i ->
                    if (s.removeRange(i..i).isPalindrome) {
                        i
                    } else {
                        -1
                    }
                }
                .first { it != -1 }
        }

}
