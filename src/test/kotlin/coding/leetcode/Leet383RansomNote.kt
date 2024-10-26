package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

//Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//Each letter in magazine can only be used once in ransomNote.

class Leet383RansomNote {

    private fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val magazineLetters = magazineLettersMap(magazine)
        ransomNote.toCharArray().forEach { c ->
            val available = magazineLetters.getOrDefault(c, 0)
            if (available > 0) {
                magazineLetters[c] = available - 1
            } else {
                return false
            }
        }
        return true
    }

    private fun magazineLettersMap(magazine: String): MutableMap<Char, Int> {
        val magazineLetters = mutableMapOf<Char, Int>()
        magazine.toCharArray().forEach { c ->
            val n = magazineLetters.getOrDefault(c, 0)
            magazineLetters[c] = n + 1
        }
        return magazineLetters
    }


    @Test
    fun example1_3() {
        assertThat(
            canConstruct(ransomNote = "a", magazine = "b")
        ).isFalse
        assertThat(
            canConstruct(ransomNote = "aa", magazine = "ab")
        ).isFalse
        assertThat(
            canConstruct(ransomNote = "aa", magazine = "aab")
        ).isTrue
    }


}