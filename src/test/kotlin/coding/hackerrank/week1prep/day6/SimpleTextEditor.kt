package coding.hackerrank.week1prep.day6

import org.junit.jupiter.api.Test
import java.util.*

class SimpleTextEditor {
    @Test
    fun `example 1`() {
        val editor = Editor()
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
            .forEach { processInputLine(it, editor) }
    }

    fun main() {
        val numberQueries = readLine()!!.toInt()
        val history = Editor()
        (0 until numberQueries).forEach { _ ->
            processInputLine(readLine()!!, history)
        }

    }

    interface Undo {
        fun undo(s: StringBuilder)
    }

    data class UndoAppend(
        val previousSize: Int
    ) : Undo {
        override fun undo(s: StringBuilder) {
            s.setLength(previousSize)
        }
    }

    data class UndoRemove(
        val removedText: String
    ) : Undo {
        override fun undo(s: StringBuilder) {
            s.append(removedText)
        }
    }

    data class Editor(
        val value: StringBuilder = StringBuilder(""),
        val history: Stack<Undo> = Stack()
    ) {
        fun append(s: String) {
            history.push(UndoAppend(value.length))
            value.append(s)
        }

        fun removeLast(n: Int) {
            val range = value.length - n until value.length
            history.push(UndoRemove(value.substring(range)))
            value.setLength(range.first)
        }

        fun get(n: Int) = value[n]

        fun undo() {
            history.pop().undo(value)
        }
    }

    private fun processInputLine(line: String, editor: Editor) {
        val tokens = line.split(" ")
        when (tokens[0].toInt()) {
            1 -> editor.append(tokens[1])
            2 -> editor.removeLast(tokens[1].toInt())
            3 -> println(editor.get(tokens[1].toInt() - 1))
            4 -> editor.undo()
        }
    }
}