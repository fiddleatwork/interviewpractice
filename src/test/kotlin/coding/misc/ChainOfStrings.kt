package coding.misc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

//
// Source: https://leetcode.com/discuss/general-discussion/1297783/Circle-of-strings-oror-GRAPHS-oror-MICROSOFT-oror-EASY-oror-C%2B%2B
//
//Given an array of strings, find if the given strings can be chained to form a circle. A string X can be put before another string Y in a circle if the last character of X is the same as the first character of Y.
//Eg.
//
//Input: arr[] = {"aab", "bac", "aaa", "cda"}
//Output: Yes, the given strings can be chained.
//The strings can be chained as "aaa", "aab", "bac"
//and "cda"
//
//Input: arr[] = {"aaa", "bbb"};
//Output: No
//
//N = 4
//A[] = { "ab" , "bc", "cd", "de" }
//Output:
//false
//

private fun chainable(firstChar: Char, lastChar: Char, list: List<String>): Boolean {
    // "aab", "bac", "aaa", "cda"
    if(list.isEmpty()) {
        return lastChar == firstChar
    }
    val candidates = list.filter { it.startsWith(lastChar) }
    candidates.forEach { c ->
        if(chainable(firstChar, c.last(), list - c)) {
            return true
        }
    }
    return false
}

private fun List<String>.chainable(): Boolean {
    // "aab", "bac", "aaa", "cda"
    if(isEmpty()) {
        return false
    }
    return chainable(first().first(), first().last(), drop(1))
}

class ChainOfStringsTest {


    @Test
    fun `example 1 can chain`() {
        assertThat(
            listOf("aab", "bac", "aaa", "cda").chainable()
        ).isTrue
    }

    @Test
    fun `example 2 can not chain`() {
        assertThat(
            listOf("aaa", "bbb").chainable()
        ).isFalse
    }

    @Test
    fun `Multiple Possible Chains`() {
        assertThat(
            listOf("abc", "bca", "cab").chainable()
        ).isTrue
    }

    @Test
    fun `dead end`() {
        assertThat(
            listOf("abc", "bcd", "cde").chainable()
        ).isFalse
    }
    @Test
    fun `Overlapping Strings`() {
        assertThat(
            listOf("ab", "abc").chainable()
        ).isFalse
    }


    // AI generated tests
    // Note that both Gemini & ChatGPT gave bad examples of chainable test cases which were not.
    // This was a relatively simple algo and the AI couldn't do it.  Very disappointing!
    // Try it yourself using the prompt of the question.
    // I updated the isTrue/isFalse to expect the correct result.


    @Test
    fun `Basic Chainable Example with 3 Strings`() {
        assertThat(
            listOf("abc", "cde", "eab").chainable()
        ).isFalse
    }

    @Test
    fun `Chainable with Repeated Characters`() {
        assertThat(
            listOf("aab", "bbc", "cca", "aad").chainable()
        ).isFalse
    }

    @Test
    fun `All Strings with Same First and Last Character`() {
        assertThat(
            listOf("aba", "cac", "ded", "efe").chainable()
        ).isFalse
    }

    @Test
    fun `Larger Set of Chainable Strings`() {
        assertThat(
            listOf("giraffe", "elephant", "tiger", "rabbit", "tapir", "rat", "tig").shuffled().chainable()
        ).isTrue
    }

    @Test
    fun `Chainable Edge Case with Two Strings`() {
        assertThat(
            listOf("ab", "ba").chainable()
        ).isTrue
    }

    @Test
    fun `Chainable with Duplicate Strings`() {
        assertThat(
            listOf("aba", "aba", "bac", "cab").chainable()
        ).isFalse
    }

    @Test
    fun `Non-Chainable due to Single Mismatch`() {
        assertThat(
            listOf("abc", "cde", "efg").chainable()
        ).isFalse
    }

    @Test
    fun `Non-Chainable due to Isolated String`() {
        assertThat(
            listOf("abc", "cba", "xyz").chainable()
        ).isFalse
    }

    @Test
    fun `One String Breaks the Circle`() {
        assertThat(
            listOf("ab", "bc", "cd", "de", "fa").chainable()
        ).isFalse
    }

    @Test
    fun `Non-Chainable with Duplicate Strings that Can't Chain`() {
        assertThat(
            listOf("abc", "cba", "bac", "dcb").chainable()
        ).isFalse
    }

    @Test
    fun `Non-Chainable Edge Case with Two Strings`() {
        assertThat(
            listOf("ab", "cd").chainable()
        ).isFalse
    }

    @Test
    fun `Self-contained Loop but No Complete Circle`() {
        assertThat(
            listOf("ab", "bc", "ca", "de").chainable()
        ).isFalse
    }

    @Test
    fun `Single String that Can Form a Circle`() {
        assertThat(
            listOf("aba").chainable()
        ).isTrue
    }

    @Test
    fun `Single String that Cannot Form a Circle`() {
        assertThat(
            listOf("abc").chainable()
        ).isFalse
    }

    @Test
    fun `Empty Array`() {
        assertThat(
            listOf<String>().chainable()
        ).isFalse
    }

    @Test
    fun `Array of Single Character Strings with All the Same Character`() {
        assertThat(
            listOf("a", "a", "a").chainable()
        ).isTrue
    }

    @Test
    fun `Array of Single Character Strings with Mixed Characters`() {
        assertThat(
            listOf("a", "b", "c").chainable()
        ).isFalse
    }

    @Test
    fun `All Strings with Same Start and End Characters but No Chain`() {
        assertThat(
            listOf("ab", "bc", "ca", "da").chainable()
        ).isFalse
    }


}