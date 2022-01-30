package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

/**
 * The ListNode object (defined by LeetCode) is not immutable and as a result this solution is not very pretty..
 * I haven't worked with mutable code like this in years and it feels strange.
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var pointer1: ListNode? = list1
    var pointer2: ListNode? = list2
    var resultHead: ListNode? = null
    var resultPointer: ListNode? = null
    while (pointer1 != null || pointer2 != null) {
        val lowest = lowest(pointer1, pointer2)
        if (resultHead == null) {
            resultHead = ListNode(lowest.`val`)
            resultPointer = resultHead
        } else {
            val newNode = ListNode(lowest.`val`)
            resultPointer!!.next = newNode
            resultPointer = newNode
        }
        if (lowest == pointer1) {
            pointer1 = pointer1.next
        } else {
            pointer2 = pointer2!!.next
        }
    }
    return resultHead
}

private fun lowest(pointer1: ListNode?, pointer2: ListNode?) = when {
    pointer1 != null && pointer2 == null -> pointer1
    pointer1 == null && pointer2 != null -> pointer2
    pointer1 != null && pointer2 != null -> if (pointer1.`val` <= pointer2.`val`) pointer1 else pointer2
    else -> error("Can't happen")
}

fun mergeTwoListsOriginal(list1: ListNode?, list2: ListNode?): ListNode? {
    var pointer1: ListNode? = list1
    var pointer2: ListNode? = list2
    var resultHead: ListNode? = null
    var resultPointer: ListNode? = null
    while (pointer1 != null || pointer2 != null) {
        when {
            pointer1 != null && pointer2 == null -> {
                if (resultHead == null) {
                    resultHead = ListNode(pointer1.`val`)
                    resultPointer = resultHead
                } else {
                    val newNode = ListNode(pointer1.`val`)
                    resultPointer!!.next = newNode
                    resultPointer = newNode
                }
                pointer1 = pointer1.next
            }
            pointer1 == null && pointer2 != null -> {
                if (resultHead == null) {
                    resultHead = ListNode(pointer2.`val`)
                    resultPointer = resultHead
                } else {
                    val newNode = ListNode(pointer2.`val`)
                    resultPointer!!.next = newNode
                    resultPointer = newNode
                }
                pointer2 = pointer2.next
            }
            pointer1 != null && pointer2 != null -> {
                val first = if (pointer1.`val` <= pointer2.`val`) pointer1 else pointer2
                if (resultHead == null) {
                    resultHead = ListNode(first.`val`)
                    resultPointer = resultHead
                } else {
                    val newNode = ListNode(first.`val`)
                    resultPointer!!.next = newNode
                    resultPointer = newNode
                }
                if (first == pointer1) {
                    pointer1 = pointer1.next
                } else {
                    pointer2 = pointer2.next
                }
            }
        }
    }
    return resultHead
}


class Leet021MergeTwoSortedLists {

    @Test
    fun example1() {
        val list1 = ListNode(1, ListNode(2, ListNode(4)))
        val list2 = ListNode(1, ListNode(3, ListNode(4)))
        assertThat(mergeTwoLists(list1, list2)).isEqualTo(
            ListNode(1, ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(4))))))
        )
    }

    @Test
    fun example2() {
        val list1 = null
        val list2 = null
        assertThat(mergeTwoLists(list1, list2)).isEqualTo(null)
    }

    @Test
    fun example3() {
        val list1 = null
        val list2 = ListNode(0)
        assertThat(mergeTwoLists(list1, list2)).isEqualTo(
            ListNode(0)
        )
    }

    @Test
    fun test1() {
        val list1 = ListNode(-9, ListNode(3))
        val list2 = ListNode(5, ListNode(7))
        assertThat(mergeTwoLists(list1, list2)).isEqualTo(
            ListNode(-9, ListNode(3, ListNode(5, ListNode(7))))
        )
    }
}