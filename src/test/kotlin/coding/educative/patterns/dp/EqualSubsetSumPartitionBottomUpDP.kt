package coding.educative.patterns.dp

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EqualSubsetSumPartitionBottomUpDP {

    data class DpKey(
        val index: Int,
        val target: Int,
    )

    private fun List<Int>.hasEqualSubsetPartition(): Boolean {
        val target = sum().also { if (it % 2 != 0) return false } / 2
        val dp = Array(size) { BooleanArray(target + 1) }

        // base case where we can always get a 0 sum from an empty set
        indices.forEach { i ->
            dp[i][0] = true
        }
        // base case where we can always get a sum s from a one item set of s
        for (s in 1..target) {
            dp[0][s] = get(0) == s
        }
        // build up the table
        (1 until size).forEach { i ->
            (1..target).forEach { s ->
                // can we get the sum without the number?
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s]
                } else if (get(i) < s) {
                    // does the previous result equal the sum - current number?
                    dp[i][s] = dp[i - 1][s - get(i)]
                }
            }
        }

        // bottom right corner has our answer for target
        return dp[size - 1][target]
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
        val base = List(100) { i -> i + 1 }
        val numbers = mutableListOf<Int>()
        repeat(100) {
            numbers.addAll(base)
        }
        assertThat(
            numbers.shuffled().hasEqualSubsetPartition()
        ).isTrue
    }

}