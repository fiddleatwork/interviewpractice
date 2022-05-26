package coding.educative.patterns.kwaymerge

import coding.educative.patterns.fastslowpointers.ListNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class MergeKSortedLists {

    fun List<ListNode>.merge(): List<Int> {
        val minHeap = PriorityQueue<ListNode> { a, b -> a.value - b.value }
        forEach { n ->
            minHeap.add(n)
        }
        val sortedList = mutableListOf<Int>()
        while (minHeap.isNotEmpty()) {
            val node = minHeap.poll()
            if (node.next != null) minHeap.add(node.next)
            sortedList.add(node.value)
        }
        return sortedList
    }

    @Test
    fun example1() {
        assertThat(
            listOf(
                ListNode(2, ListNode(6, ListNode(8))),
                ListNode(3, ListNode(6, ListNode(7))),
                ListNode(1, ListNode(3, ListNode(4))),
            ).merge()
        ).isEqualTo(
            listOf(1, 2, 3, 3, 4, 6, 6, 7, 8)
        )
    }
}