package coding.educative.patterns.breadthfirst

import coding.leetcode.TreeNode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * This is for the case where the input is in an array such as [3, 9, 20, null, null, 15, 7]
 */
// For extra practice while revising
class BinaryTreeLevelOrderTraversal2 {

    fun List<Int?>.toTree(): TreeNode {
        val root = TreeNode(first()!!)
        val queue = mutableListOf(root)
        var index = 1
        while (index < size && queue.isNotEmpty()) {
            val node = queue.removeAt(0)
            node.left = get(index)
                ?.let { TreeNode(it) }
                ?.also {
                    queue.add(it)
                }
            node.right = get(index + 1)
                ?.let { TreeNode(it) }
                ?.also {
                    queue.add(it)
                }
            index += 2
        }
        println(root.toStringPretty(2))
        return root
    }

    fun TreeNode.levelOrderTraversal(): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        traverse(listOf(this), results)
        return results.toList()
    }

    fun traverse(nodes: List<TreeNode>, results: MutableList<List<Int>>) {
        if(nodes.isEmpty()) {
            return
        }
        results.add(nodes.map { n -> n.`val` })
        traverse(nodes.map { n -> listOf(n.left, n.right) }.flatten().filterNotNull(), results)
    }


    @Test
    fun example1() {
        val treeArray = listOf<Int?>(3, 9, 20, null, null, 15, 7)
        assertThat(treeArray.toTree().levelOrderTraversal()).isEqualTo(
            listOf(
                listOf(3),
                listOf(9, 20),
                listOf(15, 7),
            )
        )
    }
}