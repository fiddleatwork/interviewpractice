package coding.hackerrank.week1prep.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.math.exp

class NearYearChaos {

    @Test
    fun `example 1`() {
        assertThat(arrayOf(1, 2, 3, 5, 4, 6, 7, 8).minBribes()).isEqualTo(1)
    }


    @Test
    fun `example 2`() {
        assertThat(arrayOf(4, 1, 2, 3).minBribes()).isEqualTo(-1)
    }

    @Test
    fun `example 0a`() {
        // 2 1 5 3 4
        // 1 2 5 3 4 2b1
        // 1 2 3 5 4 3b5
        // 1 2 3 4 5 4b5
        assertThat("2 1 5 3 4".split(" ").map { it.toInt() }.toTypedArray().minBribes()).isEqualTo(3)
    }

    @CsvSource(
        value = [
            // 0
            "2 5 1 3 4, -1",
            // 1
            "5 1 2 3 7 8 6 4, -1",
            "1 2 5 3 7 8 6 4, 7",
        ]
    )
    @ParameterizedTest
    fun `test cases`(input: String, expectedBribes: Int) {
        // 2 5 1 3 4
        // 2 1 5 3 4 5b1
        // 2 1 3 5 4 5b3
        // 2 1 3 4 5 5b4
        // 1 2 3 4 5 2b1
        assertThat(
            input.split(" ")
                .map { it.toInt() }
                .toTypedArray()
                .minBribes()
        ).isEqualTo(expectedBribes)
    }


    // An attempt at a faster algo which works for some test cases but not all.
    private fun Array<Int>.minBribesFast(): Int {
        // 2 5 1 3 4
        // 1 2 3 4 5
        // 0 1 2 3 4 position start
        // 2 0 3 4 1 position end
        // x 1 x x 3

        // 1 2 5 3 7 8 6 4 start
        // 1 2 3 4 5 6 7 8 sorted
        // 0 1 4 5 3 7 8 6 4 start index
        // 1 2 3 4 5 6 7 8 sorted index
        //
        val sorted = sorted()
        println("start    " + sorted.toList())
        println("end      " + toList())

        println("start pos" + sorted.toList().map { it - 1 })
        println("end pos  " + sorted.toList().map { indexOf(it) })
        return sorted
            .map { n -> sorted.indexOf(n) - indexOf(n) }
            .run {
                println("bribes $this")
                if (this.maxOrNull()!! > 2) {
                    -1
                } else {
                    filter { it >= 0 }.sum()
                }
            }
    }

    // 1, 2, 3, 5, 4, 6, 7, 8

    // 1, 2, 3, 4, 5, 6
    // 2, 1, 3, 4, 5, 6
    // 2, 3, 1, 4, 5, 6
    // 2, 3, 4, 1, 5, 6
    private fun Array<Int>.minBribes(): Int {
        val bribes = map { it to 0 }.toMap().toMutableMap()
        var switch = true
        while (switch) {
            switch = false
            // println(this.toList())
            for (i in 0 until size - 1) {
                if (this[i] > this[i + 1]) {
                    //print("${this[i]} bribed ${this[i + 1]}")
                    bribes[this[i]] = bribes[this[i]]!! + 1
                    val temp = this[i]
                    this[i] = this[i + 1]
                    this[i + 1] = temp
                    switch = true
                }
            }
        }
        return bribes.values.run {
            //println("bribes $this")
            if (this.maxOrNull()!! > 2) {
                -1
            } else {
                sum()
            }
        }
    }

    private fun minimumBribes(q: Array<Int>) =
        q.minBribes().also {
            if (it == -1) {
                println("Too chaotic")
            } else {
                println("$it")
            }
        }
}