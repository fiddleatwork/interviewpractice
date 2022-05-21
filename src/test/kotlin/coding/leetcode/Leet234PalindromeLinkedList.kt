package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet234PalindromeLinkedList {

    fun isPalindromeLoopSolution(head: ListNode?): Boolean {
        if(head == null) {
            return true
        }
        var p = head
        var s = StringBuilder(p.`val`.toString())
        while(p!!.next != null) {
            p = p.next!!
            s.append(p.`val`.toString())
        }
        println("Found $s")
        return s.toString() == s.toString().reversed()
    }

    fun isPalindrome(head: ListNode?): Boolean {
        isPalindromeHelper(head, StringBuilder("")).apply {
            return first.toString() == second.toString()
        }
    }

    fun isPalindromeHelper(head: ListNode?, forward: StringBuilder): Pair<StringBuilder, StringBuilder> {
        if (head == null) {
            return Pair(forward, StringBuilder(""))
        }
        val pair = isPalindromeHelper(head.next, forward.append(head.`val`))
        return Pair(pair.first, pair.second.append(head.`val`))
    }

    @Test
    fun example1() {
        assertThat(
            isPalindrome(ListNode(1, ListNode(2, ListNode(2, ListNode(1)))))
        ).isTrue
    }

    @Test
    fun example2() {
        assertThat(
            isPalindrome(ListNode(1, ListNode(2)))
        ).isFalse
    }

}
