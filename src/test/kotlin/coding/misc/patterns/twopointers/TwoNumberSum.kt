package coding.misc.patterns.twopointers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TwoNumberSum {

    fun List<Int>.twoIndicesForSum(k: Int): List<Int> {
        var left = 0
        var right = size-1
        while(left < right) {
            val sum = get(left) + get(right)
            when {
                sum == k -> return listOf(left, right)
                sum > k -> right--
                else -> left++
            }
        }
        return emptyList()
    }

    @Test
    fun example1() {
        assertThat(
            listOf(1, 2, 3, 4, 6).twoIndicesForSum(6)
        ).isEqualTo(
            listOf(1,3)
        )
    }

    @Test
    fun example2() {
        assertThat(
            listOf(2, 5, 9, 11).twoIndicesForSum(11)
        ).isEqualTo(
            listOf(0,2)
        )
    }

}