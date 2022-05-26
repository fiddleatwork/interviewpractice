package coding.educative.patterns.topk

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class TopKNumbers {

    private fun List<Int>.top(k: Int): List<Int> {
        val minHeap = PriorityQueue<Int> { n1, n2 -> n1 - n2 }
        minHeap.addAll(subList(0, k))
        subList(k, size).forEach { n ->
            if (n > minHeap.peek()) {
                minHeap.poll()
                minHeap.add(n)
            }
        }
        return minHeap.toList()
    }

    @Test
    fun example() {
        assertThat(
            listOf(3, 1, 5, 12, 2, 11).top(3)
        ).isEqualTo(
            listOf(5, 12, 11)
        )
    }
}