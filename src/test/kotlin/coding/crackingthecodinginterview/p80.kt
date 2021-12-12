package coding.crackingthecodinginterview

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class P80 {

    @Test
    fun `test swap`() {
        assertThat(
            listOf(5, 99, 3, 21, 1, 49, 8).swapMinMax()
        ).isEqualTo(
            listOf(5, 1, 3, 21, 99, 49, 8)
        )


    }

    data class MinMax(
        val min: Int,
        val max: Int,
    ) {
        constructor(items: List<Int>) : this(items.minOrNull()!!, items.maxOrNull()!!)
    }


    private fun List<Int>.swapMinMax(): List<Int> =
        MinMax(this).let { m ->
            map { i ->
                when(i) {
                    m.min -> m.max
                    m.max -> m.min
                    else -> i
                }
            }
        }




}


