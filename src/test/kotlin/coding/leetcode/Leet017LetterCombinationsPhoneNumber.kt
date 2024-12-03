package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet017LetterCombinationsPhoneNumberTest {

    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) {
            return emptyList()
        }

        val letters = mapOf(
            '2' to listOf("a", "b", "c"),
            '3' to listOf("d", "e", "f"),
            '4' to listOf("g", "h", "i"),
            '5' to listOf("j", "k", "l"),
            '6' to listOf("m", "n", "o"),
            '7' to listOf("p", "q", "r", "s"),
            '8' to listOf("t", "u", "v"),
            '9' to listOf("w", "x", "y", "z"),
        )
        return digits.fold(listOf("")) {acc, c ->
            acc.flatMap {prefix ->
                letters[c]!!.map {prefix + it}
            }
        }
    }


    @Test
    fun example1() {
        assertThat(
            letterCombinations("23")
        ).isEqualTo(
            listOf(
                "ad","ae","af","bd","be","bf","cd","ce","cf"
            )
        )
    }

    @Test
    fun example2() {
        assertThat(
            letterCombinations("")
        ).isEqualTo(
            emptyList<String>()
        )
    }

    @Test
    fun example3() {
        assertThat(
            letterCombinations("2")
        ).isEqualTo(
            listOf(
                "a","b","c"
            )
        )
    }


}