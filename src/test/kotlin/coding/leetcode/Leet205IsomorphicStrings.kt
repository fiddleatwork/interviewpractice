package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet205IsomorphicStrings {

    fun isIsomorphic(s: String, t: String): Boolean {
        return s.isIsomorphicTo(t)
    }

    private fun String.isIsomorphicTo(t: String): Boolean {
        // require(length == t.length) { "Strings must be the same size" }
        val mapping = mutableMapOf<Char, Char>()
        return mapIndexed{ i, c ->
            if (!mapping.containsKey(c) && !mapping.containsValue(t[i])) {
                mapping[c] = t[i]
            }
            mapping[c]
        }.joinToString("") == t
    }

    @Test
    fun example1() {
        assertThat("egg".isIsomorphicTo("add")).isTrue
    }

    @Test
    fun example2() {
        assertThat("foo".isIsomorphicTo("bar")).isFalse
    }

    @Test
    fun example3() {
        assertThat("paper".isIsomorphicTo("title")).isTrue
    }

    @Test
    fun badc() {
        assertThat("badc".isIsomorphicTo("baba")).isFalse
    }

    @Test
    fun egcd() {
        assertThat("egcd".isIsomorphicTo("adfd")).isFalse
    }
}

