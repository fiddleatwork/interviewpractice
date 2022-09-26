package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Not proud of this but don't have time to continue right now.  To be continued..
 */
class Leet110BalancedBinaryTree {

    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return kotlin.math.abs((root.left?.height ?: 0) - (root.right?.height ?: 0)) <= 1
    }

    private val TreeNode.height: Int
        get() = kotlin.math.max(left?.height ?: 0, right?.height ?: 0) + 1

    private fun List<Int?>.asTree(): TreeNode? {
        if (isEmpty()) {
            return null
        }
        if (size == 1) {
            return TreeNode(first()!!)
        }
        val root = TreeNode(
            get(0)!!
        )
        drop(1).fillChildren(listOf(root))
        return root
    }

    private fun List<Int?>.fillChildren(nodes: List<TreeNode?>) {
        val pairs = zipWithNext()
            .filterIndexed {i, p -> i%2==0}
        nodes.forEachIndexed { i, n ->
            if (n != null && pairs.size -1 >= i) {
                n.left = pairs[i].first?.let { TreeNode(it) }
                n.right = pairs[i].second?.let { TreeNode(it) }
            }
        }
        val nextRow = nodes.flatMap { listOf(it?.left, it?.right) }
        val childValues = drop(nodes.size * 2)
        if(childValues.isNotEmpty()) {
            childValues.fillChildren(nextRow)
        }
    }

    private val example1Tree = TreeNode(
        3,
        TreeNode(9),
        TreeNode(20, TreeNode(15), TreeNode(7))
    )

    @Test
    fun `create simple tree for example 1`() {
        //val tree = listOf(1,2,2,3,3,null,null,4,4).asTree()
        val tree = listOf(3, 9, 20, null, null, 15, 7).asTree()
        assertThat(tree).isEqualTo(example1Tree)
    }

    @Test
    fun `create simple tree for example 2`() {
        //val tree = listOf(1,2,2,3,3,null,null,4,4).asTree()
        val tree = listOf(1,2,2,3,3,null,null,4,4).asTree()
        assertThat(tree).isEqualTo(example2Tree)
    }

    @Test
    fun example1() {
        assertThat(isBalanced(example1Tree)).isTrue
    }

    val example2Tree = TreeNode(
        1,
        TreeNode(
            2,
            TreeNode(3, TreeNode(4), TreeNode(4)),
            TreeNode(3),
        ),
        TreeNode(2)
    )

    @Test
    fun example2() {
        assertThat(isBalanced(example2Tree)).isFalse
    }

    @Test
    fun `failing test case`() {
        val input = listOf(1,2,2,3,null,null,3,4,null,null,4).asTree()
        println(input)
        assertThat(isBalanced(input
        )).isFalse
    }
}