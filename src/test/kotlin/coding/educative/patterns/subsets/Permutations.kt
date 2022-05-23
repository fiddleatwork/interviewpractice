package coding.educative.patterns.subsets

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Permutations {

    private fun permutations(s: List<Int>): List<List<Int>> =
        when (s.size) {
            0 -> emptyList()
            1 -> listOf(s)
            2 -> listOf(s, s.reversed())
            else -> s.mapIndexed { i, n ->
                permutations(
                    s.toMutableList().apply { removeAt(i) }
                ).map { pr ->
                    listOf(n) + pr
                }
            }.flatten()
        }


    @Test
    fun example2() {
        assertThat(
            permutations(setOf(1, 2, 3).toList())
        ).isEqualTo(
            listOf(
                listOf(1, 2, 3),
                listOf(1, 3, 2),
                listOf(2, 1, 3),
                listOf(2, 3, 1),
                listOf(3, 1, 2),
                listOf(3, 2, 1),
            )
        )
    }
}
