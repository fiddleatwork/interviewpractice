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

    return if (cache.contains(n - 1)) {
        cache[n - 1]!!
    } else {
        climbStairs(n - 1, route + 1).also {
            cache[n - 1] = it
        }
    } + if (n >= 2) {
        if (cache.contains(n - 2)) {
            cache[n - 2]!!
        } else {
            climbStairs(n - 2, route + 2).also {
                cache[n - 2] = it
            }
        }
    } else {
        0
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