package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

val cache = mutableMapOf<Int, Int>()

fun climbStairs(n: Int, route: List<Int>): Int {
    if (n == 0) {
        //println(route)
        return 1
    }

    return callCachedClimb(n, 1, route) +
        if (n >= 2) {
            callCachedClimb(n, 2, route)
        } else {
            0
        }


}

private fun callCachedClimb(n: Int, steps: Int, route: List<Int>) = if (cache.contains(n - steps)) {
    cache[n - steps]!!
} else {
    climbStairs(n - steps, route + steps).also {
        cache[n - steps] = it
    }
}

fun climbStairs(n: Int): Int {
    return climbStairs(n, emptyList())
}


class Leet070ClimbingStairs {

    @Test
    fun example2stairs() {
        assertThat(climbStairs(2)).isEqualTo(2)
    }

    @Test
    fun example3stairs() {
        assertThat(climbStairs(3)).isEqualTo(3)
    }

    @Test
    fun example4stairs() {
        assertThat(climbStairs(4)).isEqualTo(5)
    }

    @Test
    fun example38stairs() {
        assertThat(climbStairs(38)).isEqualTo(63245986)
    }
}