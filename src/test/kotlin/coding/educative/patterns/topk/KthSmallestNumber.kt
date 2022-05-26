package coding.educative.patterns.topk

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class KthSmallestNumber {

    private fun List<Int>.smallest(k: Int): Int {
        val maxHeap = PriorityQueue<Int> { a, b -> b - a }
        maxHeap.addAll(subList(0,k-1))
        subList(k, size).forEach{ n->
            if(n < maxHeap.peek()) {
                maxHeap.poll()
                maxHeap.add(n)
            }
        }
        return maxHeap.toList().last()
    }

    @Test
    fun example() {
        assertThat(
            listOf(1, 5, 12, 2, 11, 5).smallest(3)
        ).isEqualTo(
            5
        )
    }
}