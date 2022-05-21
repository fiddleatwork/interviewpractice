package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

data class TreeNode(var `val`: Int, val left: TreeNode? = null, val right: TreeNode? = null)

class Leet094BinaryTreeInorderTraversal {
    private fun inorderTraversal(root: TreeNode?): List<Int> {
        if(root == null) {
            return emptyList()
        }
        return inorderTraversal(root.left) + listOf(root.`val`) + inorderTraversal(root.right)
    }

    @Test
    fun example1() {
        val root = TreeNode(1, null, TreeNode(2, TreeNode(3, null, null), null))
        assertThat(inorderTraversal(root)).isEqualTo(
            listOf(1,3,2)
        )
    }
}