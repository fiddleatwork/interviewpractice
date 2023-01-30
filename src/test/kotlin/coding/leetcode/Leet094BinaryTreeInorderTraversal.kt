package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null) {

    override fun toString(): String {
        return "\n" + toStringPretty(0)
    }

    fun toStringPretty(indent: Int): String {
        val indentString = StringBuilder("")
        repeat(indent) { indentString.append("\t") }
        return "$indentString$`val`\n$indentString\t${right?.toStringPretty(indent+1)?:""}\n$indentString\t${left?.toStringPretty(indent+1)?:""}"
    }
}

class Leet094BinaryTreeInorderTraversal {
    private fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        return inorderTraversal(root.left) + listOf(root.`val`) + inorderTraversal(root.right)
    }

    @Test
    fun example1() {
        val root = TreeNode(1, null, TreeNode(2, TreeNode(3, null, null), null))
        assertThat(inorderTraversal(root)).isEqualTo(
            listOf(1, 3, 2)
        )
    }
}