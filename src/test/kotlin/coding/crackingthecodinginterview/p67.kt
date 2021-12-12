package coding.crackingthecodinginterview

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.abs

class P67 {


    @Test
    fun `count pairs with difference`() {
        assertThat(
            countDifferenceHash(
                input = listOf(1, 7, 5, 9, 2, 12, 3),
                k = 2
            )
        ).isEqualTo(4)
    }

    //1 [7,5,9..]
    //7 [1,5,9..]

    private fun countDifferenceHash(input: List<Int>, k: Int) =
        input
            .associateBy { it }
            .run {
                input.map { contains(it + k) }
            }
            .count { it }

    private fun countDifferenceLoop(input: List<Int>, k: Int): Int {
        var count = 0
        for (i in input.indices) {
            for (j in i until input.size) {
                if (abs(input[i] - input[j]) == k) {
                    println("Found match ${input[i]} ${input[j]}")
                    count++
                }
            }
        }
        return count
    }

    private fun countDifferenceStream(input: List<Int>, k: Int) =
        input.sumOf { n ->
            input.filter { it != n }
                .count { abs(n - it) == k }
        }.let { it / 2 }
}