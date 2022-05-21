package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet234PalindromeLinkedList {

    fun isPalindrome(head: ListNode?): Boolean {
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
