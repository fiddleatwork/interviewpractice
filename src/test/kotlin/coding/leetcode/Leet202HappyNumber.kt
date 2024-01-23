package coding.leetcode

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.pow

class Leet202HappyNumber {

    private val Int.sumOfSquaresOfDigits: Int
        get() = toString().map { i -> ((i.toDouble() - 48).pow(2)).toInt() }.sum()


    private tailrec fun isHappy(n: Int, solved: MutableList<Int> = mutableListOf()): Boolean {
        if (n == 1) return true
        if(solved.contains(n)) {
            return false
        }
        solved.add(n)
        return isHappy(n.sumOfSquaresOfDigits, solved)
    }

    @Test
    fun example1() {
        assertThat(isHappy(19)).isTrue
    }

    @Test
    fun example2() {
        assertThat(isHappy(2)).isFalse
    }

    @Test
    fun testSumOfSquaresOfDigits() {
        assertThat(19.sumOfSquaresOfDigits).isEqualTo(82)
    }

}