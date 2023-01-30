package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet637 {

    private fun TreeNode.averagesOfLevels() : List<Double> {
        val averages = mutableListOf<Double>()
        var nodes = listOf(this)
        while(nodes.isNotEmpty()) {
            averages.add(nodes.map { it.`val`}.average())
            nodes = nodes.map {listOf(it.left, it.right)}.flatten().filterNotNull()
        }
        return averages
    }

    @Test
    fun example1() {
        val tree = TreeNode(
            3,
            TreeNode(9),
            TreeNode(
                20,
                TreeNode(15),
                TreeNode(7),
            )
        )
        assertThat(tree.averagesOfLevels()).isEqualTo(
            listOf(3.0, 14.5, 11.0)
        )
    }
}