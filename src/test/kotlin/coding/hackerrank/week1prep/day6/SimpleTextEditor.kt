package coding.hackerrank.week1prep.day6

import org.junit.jupiter.api.Test
import java.util.*

class SimpleTextEditor {
    @Test
    fun `example 1`() {
        val s = StringBuilder("")
        val previousS = Stack<String>()
        """
8
1 abc
3 3
2 3
1 xy
3 2
4 
4 
3 1            
        """.trimIndent()
            .lines()
            .map { it.trim() }
            .drop(1)
            .forEach { processInputLine(it, s, previousS) }
    }

    fun main(args: Array<String>) {
        val numberQueries = readLine()!!.toInt()
        var s = StringBuilder("")
        var previousS = Stack<String>()
        (0 until numberQueries).forEach { _ ->
            processInputLine(readLine()!!, s, previousS)
        }

    }

    private fun processInputLine(line: String, s: StringBuilder, stack: Stack<String>) {
        val tokens = line.split(" ")
        when (tokens[0]) {
            "1" -> {
                stack.push(s.toString())
                s.append(tokens[1])
            }
            "2" -> {
                stack.push(s.toString())
                s.delete(s.length - tokens[1].toInt(), s.length)
            }
            "3" -> println(s[tokens[1].toInt() - 1])
            "4" -> {
                s.clear()
                s.append(stack.pop())
            }
        }
    }
}