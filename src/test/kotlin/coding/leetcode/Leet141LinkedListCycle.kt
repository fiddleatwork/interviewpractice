package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

// defined in Leet002
//class ListNode(
//    var `val`: Int
//) {
//    var next: ListNode? = null
//}

class Leet141LinkedListCycleTest {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }
        val nodes = mutableSetOf(head)
        var p = head.next
        while (p != null) {
            if (nodes.contains(p)) {
                return true
            }
            nodes.add(p)
            p = p.next
        }
        return false
    }

    @Test
    fun `example 1`() {
        val n3 = ListNode(3)
        val n2 = ListNode(2)
        val n0 = ListNode(0)
        val nm4 = ListNode(-4)
        n3.next = n2
        n2.next = n0
        n0.next = nm4
        nm4.next = n2

        assertThat(hasCycle(n3)).isTrue
    }

}