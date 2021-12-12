package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*


class Leet056MergeIntervals {

    @Test
    fun `simple test`() {
        assertThat(
            listOf(
                Pair(1, 3),
                Pair(2, 6),
                Pair(8, 10),
                Pair(15, 18),
            ).merge2()
        ).isEqualTo(
            listOf(
                Pair(1, 6),
                Pair(8, 10),
                Pair(15, 18),
            )
        )
    }

    @Test
    fun `simple test size 1`() {
        assertThat(
            listOf(
                Pair(1, 4),
            ).merge2()
        ).isEqualTo(
            listOf(
                Pair(1, 4),
            )
        )
    }

    @Test
    fun `simple test 2`() {
        assertThat(
            listOf(
                Pair(1, 4),
                Pair(4, 5),
            ).merge2()
        ).isEqualTo(
            listOf(
                Pair(1, 5),
            )
        )
    }

    @Test
    fun `bigger test`() {
        assertThat(
            listOf(
                Pair(2, 3),
                Pair(4, 5),
                Pair(6, 7),
                Pair(8, 9),
                Pair(1, 10),
            ).merge2()
        ).isEqualTo(
            listOf(
                Pair(1, 10),
            )
        )
    }

    @Test
    fun `simple test leet`() {
        assertThat(
            merge(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 6),
                    intArrayOf(8, 10),
                    intArrayOf(15, 18),
                )
            )
        ).isEqualTo(
            arrayOf(
                intArrayOf(1, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18),
            )
        )
    }

    @Test
    fun `leetcode solution test`() {
        assertThat(
            listOf(
                Pair(2, 5),
                Pair(1, 4),
                Pair(9, 10),
                Pair(6, 9),
            ).merge2()
        ).isEqualTo(
            listOf(
                Pair(1, 5),
                Pair(6, 10),
            )
        )
    }

    fun merge(intervals: Array<IntArray>): Array<IntArray> =
        intervals.map { Pair(it[0], it[1]) }
            .merge2()
            .map {
                intArrayOf(it.first, it.second)
            }
            .toTypedArray()

    /**
     * no overlap
     * overlap start
     * overlap end
     * overlap both
     */
    private fun List<Pair<Int, Int>>.merge(): List<Pair<Int, Int>> {
        val sortedIntervals = sortedWith(compareBy({ it.first }, { it.second }))
        if (sortedIntervals.isEmpty()) {
            return emptyList()
        }
        var interval = sortedIntervals.first()
        var remaining = emptyList<Pair<Int, Int>>().toMutableList()
        for (i in 1 until sortedIntervals.size) {
            val next = sortedIntervals[i]
            if (next.first > interval.second || next.second < interval.first) {
                // no overlap
                remaining.add(next)
                continue
            }
            interval = Pair(Math.min(interval.first, next.first), Math.max(interval.second, next.second))
        }
        return listOf(interval) + remaining.merge()
    }

    private fun List<Pair<Int, Int>>.merge2(): List<Pair<Int, Int>> {
        val results = LinkedList<Pair<Int, Int>>()
        sortedWith(compareBy({ it.first }, { it.second }))
            .forEach { interval ->
                if (results.isEmpty() || results.last().second < interval.first) {
                    results.add(interval)
                } else {
                    val last = results.removeLast()
                    results.add(
                        Pair(Math.min(last.first, interval.first), Math.max(last.second, interval.second))
                    )
                }
            }
        return results
    }

}