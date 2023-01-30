package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet1137NthTribonaci {

    val tribs = mutableMapOf<Int, Int>().also {
        it[0] = 0
        it[1] = 1
        it[2] = 1
    }

    fun tribonacci(n: Int): Int =
    // Tn+3 = Tn + Tn+1 + Tn+2
        // Tn = Tn-3 + Tn-2 + Tn-1
        if (tribs.containsKey(n)) tribs[n]!!
        else tribonacci(n - 3).also { tribs[n - 3] = it } +
                tribonacci(n - 2).also { tribs[n - 2] = it } +
                tribonacci(n - 1).also { tribs[n - 1] = it }

    @Test
    fun example1() {
        assertThat(tribonacci(4)).isEqualTo(4)
    }

    @Test
    fun example2() {
        assertThat(tribonacci(25)).isEqualTo(1389537)
    }
}