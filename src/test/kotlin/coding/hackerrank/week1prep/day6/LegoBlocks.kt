package coding.hackerrank.week1prep.day6

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.math.pow

/**
 * After reading some hints, I decided to skip this one.
 * As with my previous solutions, I suspect it will timeout.
 */
class LegoBlocks {

    @CsvSource(
        value = [
            "2,2,3",
            "3,2,6",
            "2,3,8",
            "2,4,0", // I don't know this value
            "4,4,32",
            "4,5,35714",
            "4,6,447902",
            "4,7,5562914",
            "5,4,29791",
            "6,4,250047",
            "7,4,250047",
        ]
    )
    @ParameterizedTest
    fun legoTest(n: Int, m: Int, expected: Int) {
        assertThat(legoBlocks(n, m)).isEqualTo(expected)
    }

    private val modFactor = (10.0.pow(9) + 7).toInt()

    fun legoBlocks(n: Int, m: Int): Int {
//        for(i in 0 until n) {
//
//        }
        // this doesn't take into account the fact that we can't have vertical lines
        return (n * legoRow(m) % modFactor)
    }

    private fun legoRow(m: Int) = 2.0.pow(m - 1).toInt()

}