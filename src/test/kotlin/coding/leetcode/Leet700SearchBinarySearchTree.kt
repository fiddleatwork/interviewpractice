package coding.leetcode

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet700SearchBinarySearchTree {

    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return null
        }
        return when {
            `val` == root.`val` -> root
            `val` < root.`val` -> searchBST(root.left, `val`)
            else -> searchBST(root.right, `val`)
        }
    }

    @Test
    fun example1() {
        val node2 = TreeNode(2, TreeNode(1), TreeNode(3))
        val root = TreeNode(
            4,
            node2,
            TreeNode(7)
        )
        assertThat(searchBST(root, 2)).isEqualTo(node2)
    }
}