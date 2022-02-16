package coding.hackerrank.week1prep.day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.abs

class Pairs {

    @Test
    fun example1() {
        assertThat(
            // 1, 5, 3, 4, 2
            // 1, 3, 2,
            pairs(2, arrayOf(1, 5, 3, 4, 2))
        ).isEqualTo(3)
    }

    @Test
    fun myExample() {
        // Apparently duplicates don't count, this was not clear in the problem statement
        assertThat(
            pairs(1, arrayOf(1, 1, 2, 2))
        ).isEqualTo(2)
    }

    fun pairs(k: Int, arr: Array<Int>): Int {
        val map = arr.associateBy { it }
        return arr.count {n -> map.containsKey(n + k)}
    }

    fun pairsBruteFunctional(k: Int, arr: Array<Int>): Int {
        return arr.map { i ->
            arr.count { j -> Math.abs(i - j) == k }
        }.sum() / 2
    }

    fun pairsBrute(k: Int, arr: Array<Int>): Int {
        val sorted = arr.sorted()
        var successes = 0
        for (i in 0 until sorted.size - 1) {
            for (j in i + 1 until sorted.size) {
                val compare = Math.abs(sorted[i] - sorted[j]).compareTo(k)
                when {
                    compare == 0 -> successes++
                    compare > 1 -> return successes
                }
            }
        }
        return successes
    }
}