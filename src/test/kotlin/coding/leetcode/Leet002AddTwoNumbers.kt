package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*


data class ListNode(
    var `val`: Int,
    var next: ListNode? = null,
) {

    override fun toString() =
        "[${toStringHelper()}]"

    private fun toStringHelper(): String =
        if (next == null) {
            "${`val`}"
        } else {
            "${`val`},${next!!.toStringHelper()},"
        }
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {

    @Test
    fun `simple test`() {
        val first = ListNode(2)
        first.next = ListNode(4)
        first.next!!.next = ListNode(3)
        val second = ListNode(5)
        second.next = ListNode(6)
        second.next!!.next = ListNode(4)

        val expected = ListNode(7)
        expected.next = ListNode(0)
        expected.next!!.next = ListNode(8)

        assertThat(addTwoNumbers(first, second)).isEqualTo(expected)
    }

    @Test
    fun `test 2`() {
        val first = ListNode(9)
        first.next = ListNode(9)
        first.next!!.next = ListNode(9)
        first.next!!.next!!.next = ListNode(9)
        first.next!!.next!!.next!!.next = ListNode(9)
        first.next!!.next!!.next!!.next!!.next = ListNode(9)
        first.next!!.next!!.next!!.next!!.next!!.next = ListNode(9)
        val second = ListNode(9)
        second.next = ListNode(9)
        second.next!!.next = ListNode(9)
        second.next!!.next!!.next = ListNode(9)

        val expected = ListNode(8)
        expected.next = ListNode(9)
        expected.next!!.next = ListNode(9)
        expected.next!!.next!!.next = ListNode(9)
        expected.next!!.next!!.next!!.next = ListNode(0)
        expected.next!!.next!!.next!!.next!!.next = ListNode(0)
        expected.next!!.next!!.next!!.next!!.next!!.next = ListNode(0)
        expected.next!!.next!!.next!!.next!!.next!!.next!!.next = ListNode(1)

        println("Expected: $expected")
        assertThat(addTwoNumbers(first, second)).isEqualTo(expected)
    }

    @Test
    fun `test 2 LinkedList`() {
        val first = LinkedList(listOf(9,9,9,9,9,9,9))
        val second = LinkedList(listOf(9,9,9,9))
        val expected = LinkedList(listOf(8,9,9,9,0,0,0,1))
        assertThat(addTwoNumbers2(first, second)).isEqualTo(expected)
    }

    fun addTwoNumbers2(l1: LinkedList<Int>, l2: LinkedList<Int>): LinkedList<Int> {
        // to complex for streams?
//        val lists = if(l1.size > l2.size) Pair(l1,l2) else Pair(l2,l1)
//        lists.flatMap { b: LinkedList<Int>,s: LinkedList<Int> ->
        // 1,4,5,8
        // 2,8
//        val zipped = l1.zip(l2)
//        zipped.flatMap { z ->
//            val sum = (z.first + z.second).let { s->
//                if(s > 10) {
//
//                }
//            }
//
//        }
//        }
        return LinkedList<Int>()
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? = null

//    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
//        var i = 0
//        var carry = 0
//        var next1 = l1
//        var next2 = l2
//        var answerHead : ListNode? = null
//        var answer: ListNode? = null
//        do {
//            //println("i=$i answerHead=$answerHead")
//            val sum = (
//                when {
//                    next1 == null && next2 != null -> next2.`val`
//                    next1 != null && next2 == null -> next1.`val`
//                    next1 == null && next2 == null -> 0
//                    next1 != null && next2 != null -> next1.`val` + next2.`val`
//                    else -> error("Invalid state")
//                } + carry
//                ).let {
//                    if (it > 9) {
//                        carry = 1
//                        it - 10
//                    } else {
//                        carry = 0
//                        it
//                    }
//                }
//
//            if (answer == null) {
//                answer = ListNode(sum)
//                answerHead = answer
//            } else {
//                answer.next = ListNode(sum)
//                answer = answer.next!!
//            }
//            i++
//            next1 = next1?.next
//            next2 = next2?.next
//        } while (carry > 0 || next1 != null || next2 != null)
//        return answerHead
////            .also {
////                println(it)
////            }
//    }


}