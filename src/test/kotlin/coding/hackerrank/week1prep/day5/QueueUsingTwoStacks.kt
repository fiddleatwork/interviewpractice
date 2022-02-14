package coding.hackerrank.week1prep.day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class QueueUsingTwoStacks {

    @Test
    fun `example 1`() {
        // stack1: 14 28 66
        // stack2:
        val q = Queue()
        q.enqueue(42)
        q.dequeue()
        q.enqueue(14)
        assertThat(q.printFirst()).isEqualTo(14)
        q.enqueue(28)
        assertThat(q.printFirst()).isEqualTo(14)
        q.enqueue(60)
        q.enqueue(78)
        q.dequeue()
        q.dequeue()
    }
}

fun main(args: Array<String>) {
    val numberQueries = readLine()!!.toInt()
    val queue = Queue()
    (0 until numberQueries).forEach { _ ->
        processInputLine(readLine()!!, queue)
    }
}

private fun processInputLine(input: String, queue: Queue) {
    when (val action = input.split(" ")[0].toInt()) {
        1 -> queue.enqueue(input.split(" ")[1].toInt())
        2 -> queue.dequeue()
        3 -> queue.printFirst()
        else -> error("Invalid action $action")
    }
}

class Queue {

    private val stack1 = Stack<Int>()
    private val stack2 = Stack<Int>()

    fun printFirst(): Int = stack1.peek().also { println(it) }

    fun dequeue(): Int = stack1.pop()

    fun enqueue(value: Int) {
        while (stack1.size > 0) {
            stack2.push(stack1.pop())
        }
        stack1.push(value)
        while (stack2.size > 0) {
            stack1.push(stack2.pop())
        }
    }

}


