package coding.educative.patterns.slidingwindow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class `01SlidingWindowAverages` {

    private fun List<Int>.averages(k: Int): List<Double> {
        val averages = mutableListOf<Double>()
        var sum = 0
        indices.forEach{ i ->
            //println("i=$i")
            sum += get(i)
            if(i >= k-1) {
                averages.add(sum.toDouble()/k)
                sum -= get(i-k+1)
            }
        }
        return averages
    }

    @Test
    fun example1() {
        assertThat(
            listOf(1, 3, 2, 6, -1, 4, 1, 8, 2).averages(5)
        )    .isEqualTo(
            listOf(2.2, 2.8, 2.4, 3.6, 2.8)
        )
    }

}

