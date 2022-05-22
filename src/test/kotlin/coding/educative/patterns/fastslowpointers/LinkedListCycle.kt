package coding.educative.patterns.fastslowpointers

import coding.leetcode.Leet141LinkedListCycleTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

data class ListNode(var value: Int, var next: ListNode? = null) {
    override fun toString() =
        "[${toStringHelper()}]"

    private fun toStringHelper(): String =
        if (next == null) {
            "$value"
        } else {
            "$value,${next!!.toStringHelper()}"
        }
}

class LinkedListCycle {

    private fun ListNode.hasCycle() : Boolean {
        var slow = this
        var fast = this
        while(slow.next != null && fast.next != null && fast.next!!.next != null) {
            slow = slow.next!!
            fast = fast.next!!.next!!
            if(slow == fast) {
                return true
            }
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

        Assertions.assertThat(n3.hasCycle()).isTrue
    }
}