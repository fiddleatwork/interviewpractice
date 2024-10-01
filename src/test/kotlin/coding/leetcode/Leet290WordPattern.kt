package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet290WordPatternTest {

    fun wordPattern(pattern: String, s: String): Boolean {
        return s.matches(pattern)
    }

    private fun String.matches(pattern: String): Boolean {
        val lookup = mutableMapOf<Char, String>()
        val tokens = split(" ")
        return this == pattern.asIterable().mapIndexed {i, c ->
            if(i >= tokens.size) {
                return false
            }
            if(c !in lookup.keys && tokens[i] !in lookup.values) {
                lookup[c] = tokens[i]
            }
            lookup[c]
        }.joinToString(" ")
    }

    @Test
    fun example1() {
        assertThat("dog cat cat dog".matches("abba")).isTrue
    }

    @Test
    fun example2() {
        assertThat("dog cat cat fish".matches("abba")).isFalse
    }

    @Test
    fun example3() {
        assertThat("dog cat cat dog".matches("aaaa")).isFalse
    }

    @Test
    fun abba() {
        assertThat("dog dog dog dog".matches("abba")).isFalse
    }
}


