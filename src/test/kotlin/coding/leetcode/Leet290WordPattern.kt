package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet290WordPatternTest {

    fun wordPattern(pattern: String, s: String): Boolean {
        return s.matches(pattern)
    }

    private fun String.matches(pattern: String): Boolean {
        val lookupWord = mutableMapOf<Char, String>()
        val lookupLetter = mutableMapOf<String, Char >()
        val tokens = split(" ")
        if(tokens.size != pattern.length) {
            return false
        }
        return pattern.asIterable().mapIndexed {i, c ->
            if(i >= tokens.size) {
                return false
            }
            lookupLetter.putIfAbsent(tokens[i], c)
            lookupWord.putIfAbsent(c, tokens[i])
            lookupWord[c] == tokens[i] && lookupLetter[tokens[i]] == c
        }.all{it}
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

    @Test
    fun aaa() {
        assertThat("aa aa aa aa".matches("aaa")).isFalse
    }
}


