package coding.educative.patterns.dp

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EqualSubsetSumPartitionTopDownDP {

    data class DpKey(
        val index: Int,
        val target: Int,
    )

    private fun List<Int>.hasEqualSubsetPartition(): Boolean {
        val s = sum()
        if (s % 2 != 0) {
            return false
        }
        val dp = mutableMapOf<DpKey, Boolean>()
        return hasEqualSubsetPartition(dp, s / 2, 0)
//            .also {
//                println("dp = $dp")
//            }
    }

    private fun List<Int>.hasEqualSubsetPartition(
        dp: MutableMap<DpKey, Boolean>,
        target: Int = 0,
        index: Int = 0
    ): Boolean {
        if (target == 0) {
            return true
        }
        if (isEmpty() || index >= size) {
            return false
        }
        val dpKey = DpKey(index, target)
        if (dp.containsKey(dpKey)) {
            println("Avoided a call thanks to DP $dpKey")
            return dp[dpKey]!!
        }
        if (get(index) <= target && hasEqualSubsetPartition(dp, target - get(index), index + 1)) {
            dp[dpKey] = true
            return true
        }
        dp[dpKey] = hasEqualSubsetPartition(dp, target, index + 1)
        return dp[dpKey]!!
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
            listOf(2, 3, 4, 6).hasEqualSubsetPartition()
        ).isFalse
    }

    @Test
    fun `from one to eleven`() {
        assertThat(
            listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11).hasEqualSubsetPartition()
        ).isTrue
    }

    @Test
    fun `from one to seven`() {
        assertThat(
            listOf(1, 2, 3, 4, 5, 6, 7).hasEqualSubsetPartition()
        ).isTrue
    }

    @Test
    fun `big example`() {
        val base = List(1000) { i -> i + 1 }
        assertThat(
            (base + base + base + base).shuffled().hasEqualSubsetPartition()
        ).isTrue
    }

}