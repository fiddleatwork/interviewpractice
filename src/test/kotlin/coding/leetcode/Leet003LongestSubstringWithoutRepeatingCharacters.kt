package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.max

class Leet003LongestSubstringWithoutRepeatingCharactersTest {

    fun lengthOfLongestSubstring(s: String): Int {
        if(s.isEmpty()) {
            return 0
        }
        var max = 1
        s.indices.forEach { start ->
            for (i in start + 1 until s.length) {
                val substring = s.substring(start, i)
                if (substring.indexOf(s[i]) > -1) {
                    break
                }
                max = max(max, substring.length + 1)
            }
        }
        return max
    }

    @Test
    fun testExample1() {
        assertThat(lengthOfLongestSubstring("abcabcbb")).isEqualTo(3)
    }

    @Test
    fun testExample2() {
        assertThat(lengthOfLongestSubstring("bbbbb")).isEqualTo(1)
    }

    @Test
    fun testExample3() {
        assertThat(lengthOfLongestSubstring("pwwkew")).isEqualTo(3)
    }

}