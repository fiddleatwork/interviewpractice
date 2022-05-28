package coding.educative.patterns.dp

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EqualSubsetSumPartition {

    private fun List<Int>.hasEqualSubsetPartition(): Boolean {
        val s = sum()
        if (s % 2 != 0) {
            return false
        }
        return hasEqualSubsetPartition(s / 2, 0)
    }

    private fun List<Int>.hasEqualSubsetPartition(target: Int = 0, index: Int = 0): Boolean {
        if (target == 0) {
            return true
        }
        if (isEmpty() || index >= size) {
            return false
        }
        if (get(index) <= target) {
            if (hasEqualSubsetPartition(target - get(index), index + 1)) {
                println("n = ${get(index)}")
                return true
            }
        }
        return hasEqualSubsetPartition(target, index + 1)
    }

    @Test
    fun example1() {
        assertThat(
            listOf(1, 2, 3, 4).hasEqualSubsetPartition()
        ).isTrue
    }

    @Test
    fun example2() {
        assertThat(
            listOf(2,3,4,6).hasEqualSubsetPartition()
        ).isFalse
    }

}