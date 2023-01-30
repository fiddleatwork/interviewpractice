package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet69SquareRoot {
    fun mySqrt(x: Int): Int {
        var n = 0L
        while(n*n <= x.toLong()) {
            n++
        }
        return (n-1).toInt()
    }

    @Test
    fun `example 2`() {
        assertThat(mySqrt(8)).isEqualTo(2)
    }

    @Test
    fun `test 15`() {
        assertThat(mySqrt(2147395600)).isEqualTo(46340)
    }
}