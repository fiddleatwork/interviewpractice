package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class Leet006ZigZag {

    @Test
    fun `test case 1`() {
        assertThat(convert("PAYPALISHIRING", 3)).isEqualTo("PAHNAPLSIIGYIR")
    }

    @Test
    fun `test case 2`() {
        assertThat(convert("PAYPALISHIRING", 4)).isEqualTo("PINALSIGYAHRPI")
    }

    @Test
    fun `test case 3`() {
        assertThat(convert("A", 1)).isEqualTo("A")
    }

    @Test
    fun `submit test case 1`() {
        assertThat(convert("ABCDE", 4)).isEqualTo("ABCED")
    }

    enum class Direction {
        Down, Up
    }

    fun convert(s: String, numRows: Int): String {
        val result = mutableListOf<String>()
        var index = 0
        while (index < s.length) {
            val fullColumn = s.substring(index until Math.min(s.length, index + numRows))
                .let {
                    val padding = StringBuilder()
                    for (i in 0 until numRows - it.length) {
                        padding.append(" ")
                    }
                    it + padding.toString()
                }
            result.add(fullColumn)
            index += fullColumn.length
            if (index >= s.length) {
                break
            }
            var charIndex = numRows - 2
            for (i in 0 until (numRows - 2)) {
                val zigZagColumn = StringBuffer()
                if (index >= s.length) {
                    break
                }
                for (j in 0..numRows) {
                    if (j == charIndex) {
                        zigZagColumn.append(s.substring(index until index + 1))
                        index++
                    } else {
                        zigZagColumn.append(" ")
                    }
                }
                charIndex--
                println("Adding '$zigZagColumn'")
                result.add(zigZagColumn.toString())
            }

            println(result)
        }
        println("\nFinal: $result")
        return result.toOutputFormat(numRows)
    }

    fun List<String>.toOutputFormat(numRows: Int): String {
        val result = StringBuilder()
        for (i in 0 until numRows) {
            for (j in 0 until size) {
                val s = get(j).substring(i until i + 1)
                if (s != " ") {
                    result.append(get(j).substring(i until i + 1))
                }
            }
        }
        return result.toString()
    }
}
