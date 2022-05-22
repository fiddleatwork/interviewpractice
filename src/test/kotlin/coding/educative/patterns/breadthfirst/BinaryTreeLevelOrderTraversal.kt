package coding.educative.patterns.breadthfirst

import coding.leetcode.TreeNode
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BinaryTreeLevelOrderTraversal {

    private fun levelOrderTraversal(node: TreeNode) : List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>(mutableListOf())
        levelOrderTraversal(node, result, 0)
        return result
    }

    private fun levelOrderTraversal(node: TreeNode?, result: MutableList<MutableList<Int>>, depth: Int) {
        if(node == null) {
            return
        }
        if(result.size < depth+1) {
            result.add(mutableListOf())
        }
        result[depth].add(node.`val`)
        levelOrderTraversal(node.left, result, depth+1)
        levelOrderTraversal(node.right, result, depth+1)
    }


    @Test
    fun example1() {
        val root = TreeNode(
            12,
            TreeNode(
                7,
                TreeNode(9, null, null),
                null
            ),
            TreeNode(
                1,
                TreeNode(10, null, null),
                TreeNode(5, null, null),
            )
        )
        assertThat(levelOrderTraversal(root)).isEqualTo(
            listOf(listOf(12), listOf(7,1), listOf(9,10,5))
        )
    }
}