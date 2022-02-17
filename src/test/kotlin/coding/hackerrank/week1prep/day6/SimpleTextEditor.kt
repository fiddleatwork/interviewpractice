package coding.hackerrank.week1prep.day6

import org.junit.jupiter.api.Test
import java.util.*

class SimpleTextEditor {
    @Test
    fun `example 1`() {
        val stack = Stack<String>()
        stack.push("")
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
            .forEach { processInputLine(it, stack) }
    }

    fun main(args: Array<String>) {
        val numberQueries = readLine()!!.toInt()
        val stack = Stack<String>()
        stack.push("")
        (0 until numberQueries).forEach { _ ->
            processInputLine(readLine()!!, stack)
        }

    }

    private fun processInputLine(line: String, stack: Stack<String>) {
        val tokens = line.split(" ")
        when (tokens[0]) {
            "1" -> {
                stack.push(stack.peek() + tokens[1])
            }
            "2" -> {
                stack.peek().let { s ->
                    stack.push(s.removeRange(s.length - tokens[1].toInt() until s.length))
                }
            }
            "3" -> println(stack.peek()[tokens[1].toInt() - 1])
            "4" -> {
                stack.pop()
            }
        }
    }
}