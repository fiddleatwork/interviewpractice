package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

// defined in Leet002
//class ListNode(
//    var `val`: Int
//) {
//    var next: ListNode? = null
//}

fun ListNode.tail() : ListNode? {
    var tail: ListNode? = this
    while (tail?.next != null) {
        tail = tail.next
    }
    return tail
}

// 1 -> 2 -> 3 -> 4 -> 5 -> null
fun reverseList(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    val n = reverseList(head.next) ?: return head
    head.next = null
    n.tail()!!.next = head
    return n
}

class Leet206ReverseLinkedListTest {

    @Test
    fun `example 1`() {
        val ll = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))

        println("List $ll")
        val reversedList = reverseList(ll)!!
        println("Reversed $reversedList")
        assertThat(reversedList.`val`).isEqualTo(5)
        assertThat(reversedList.next!!.`val`).isEqualTo(4)
        assertThat(reversedList.next!!.next!!.`val`).isEqualTo(3)
        assertThat(reversedList.next!!.next!!.next!!.`val`).isEqualTo(2)
        assertThat(reversedList.next!!.next!!.next!!.next!!.`val`).isEqualTo(1)
    }

    @Test
    fun `example 2`() {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        node1.next = node2

        val reversedList = reverseList(node1)!!
        assertThat(reversedList.`val`).isEqualTo(2)
        assertThat(reversedList.next!!.`val`).isEqualTo(1)
    }

    @Test
    fun `example 3`() {
        val reversedList = reverseList(null)
        assertThat(reversedList).isNull()
    }

}