package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.pow


class Leet014LongestCommonPrefix {

    @Test
    fun `example 1`() {
        assertThat(listOf("flower", "flow", "flight").longestCommonPrefix()).isEqualTo("fl")
    }

    @Test
    fun `example 2`() {
        assertThat(listOf("dog", "racecar", "car").longestCommonPrefix()).isEqualTo("")
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        return strs.toList().longestCommonPrefix()
    }

    private fun List<String>.longestCommonPrefix(): String {
        val smallest = sorted().first()
        for (i in smallest.length - 1 downTo 0) {
            val candidate = smallest.substring(0..i)
            //println("Checking $candidate")
            if (all { it.startsWith(candidate) }) {
                return candidate
            }
        }
        return ""
    }

}