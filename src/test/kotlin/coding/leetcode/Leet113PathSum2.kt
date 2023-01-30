package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet113PathSum2 {

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if(root == null) {
            return emptyList()
        }
        val solutions = mutableListOf<List<Int>>()
        pathSum(root, targetSum,  emptyList(), solutions)
        return solutions.toList()
    }

    fun pathSum(
        root: TreeNode,
        sum: Int,
        path: List<Int>,
        solutions: MutableList<List<Int>>,
    ) {
        if (root.left == null && root.right == null) {
            if (root.`val` == sum) {
                solutions.add(path + root.`val`)
            }
        }
        if (root.left != null) {
            pathSum(root.left!!, sum - root.`val`, path + root.`val`, solutions)
        }
        if (root.right != null) {
            pathSum(root.right!!, sum - root.`val`, path + root.`val`, solutions)
        }
    }

    @Test
    fun example1() {
        val tree = TreeNode(
            5,
            TreeNode(
                4,
                TreeNode(
                    11,
                    TreeNode(
                        7
                    ),
                    TreeNode(
                        2
                    )
                )
            ),
            TreeNode(
                8,
                TreeNode(13),
                TreeNode(
                    4,
                    TreeNode(5),
                    TreeNode(1),
                )
            )
        )
       assertThat(pathSum(tree, 22)).isEqualTo(
            listOf(
                listOf(5, 4, 11, 2),
                listOf(5, 8, 4, 5),
            )
        )
    }

    @Test
    fun example2() {
        val tree = TreeNode(
            1,
            TreeNode(2, null, null),
            TreeNode(3, null, null),
        )
        assertThat(pathSum(tree, 5)).isEqualTo(mutableListOf<List<Int>>())
    }

}
