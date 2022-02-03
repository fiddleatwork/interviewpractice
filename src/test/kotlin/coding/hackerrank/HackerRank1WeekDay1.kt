package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MinMaxSum {
    fun miniMaxSum(arr: Array<Int>) {
        val sorted = arr.sorted().toList().map { it.toLong() }
        val minSum = sorted.dropLast(1).sum()
        val maxSum = sorted.drop(1).sum()
        println("$minSum $maxSum")
    }
}

class TimeConversion {
    @Test
    fun `should parse am-pm`() {
        assertThat("12:01:00PM".amPm).isEqualTo(AmPm.PM)
        assertThat("12:01:00AM".amPm).isEqualTo(AmPm.AM)
    }

    @CsvSource(
        value = [
            "12:01:00PM, 12:01:00",
            "12:01:00AM, 00:01:00",
        ]
    )
    @ParameterizedTest
    fun `should convert to military`(input: String, expectedOutput: String) {
        assertThat(timeConversion(input)).isEqualTo(expectedOutput)
    }

    @CsvSource(
        value = [
            "01,PM, 13",
            "10,PM, 22",
            "12,PM, 12",
            "01,AM, 01",
            "10,AM, 10",
            "12,AM, 00",
        ]
    )
    @ParameterizedTest
    fun `should convert hour to military`(hour: String, am: AmPm, expectedMilitaryHour: String) {
        assertThat(toMilitaryHour(hour, am)).isEqualTo(expectedMilitaryHour)
    }

    enum class AmPm {
        AM, PM
    }

    private val String.amPm: AmPm
        get() = AmPm.valueOf(substring(length - 2))

    private val String.hour: String
        get() = substring(0 until 2)

    private fun toMilitaryHour(hour: String, amPm: AmPm) =
        when (amPm) {
            AmPm.AM -> if (hour == "12") {
                "00"
            } else {
                hour
            }
            AmPm.PM -> if (hour == "12") {
                hour
            } else {
                (hour.toInt() + 12).toString().let {
                    if (it.length == 1) {
                        "0$it"
                    } else {
                        it
                    }
                }
            }
        }

    fun timeConversion(s: String) = toMilitaryHour(s.hour, s.amPm) + s.substring(2 until s.length - 2)

}

class FindMedian {

    @Test
    fun `should find median`() {
        assertThat(findMedian(arrayOf(5, 3, 1, 2, 4))).isEqualTo(3)
        assertThat(findMedian(arrayOf(5, 3, 1, 2, 4))).isEqualTo(3)
    }

    fun findMedian(arr: Array<Int>): Int =
        arr.sorted()[arr.size / 2]

}