package coding.educative.patterns.slidingwindow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.max

class `01SlidingWindowMaxSum` {

    fun List<Int>.maxSum(k: Int) : Int {
        var sum = 0
        var maxSum = Int.MIN_VALUE
        indices.forEach {i ->
            sum += get(i)
            if(i >= k-1) {
                maxSum = max(maxSum, sum)
                sum -= get(i-k+1)
            }
        }
        return maxSum
    }


    @Test
    fun example1() {
        assertThat(
            listOf(
                2, 1, 5, 1, 3, 2
            ).maxSum(3)
        ).isEqualTo(9)
    }

    @Test
    fun example2() {
        assertThat(
            listOf(
                2, 3, 4, 1, 5
            ).maxSum(2)
        ).isEqualTo(7)
    }
}