package coding.educative.patterns.reverselinkedlist

import coding.educative.patterns.fastslowpointers.ListNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ReverseLinkedList {

    fun ListNode.reversed(): ListNode? {
        var previous: ListNode? = null
        var current: ListNode? = this
        while(current != null) {
            val next = current.next
            current.next = previous
            previous = current
            current = next
        }
        return previous
    }

    @Test
    fun example1() {
        assertThat(
            ListNode(2, ListNode(4, ListNode(6, ListNode(8, ListNode(10))))).reversed()
        ).isEqualTo(
            ListNode(10, ListNode(8, ListNode(6, ListNode(4, ListNode(2)))))
        )
    }
}