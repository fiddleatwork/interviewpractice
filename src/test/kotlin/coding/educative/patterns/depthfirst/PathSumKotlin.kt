package coding.educative.patterns.depthfirst

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private fun MyTreeNode.pathSum(sum: Int): Boolean {
    if(left == null && right == null) {
        return value == sum
    }
    return left?.pathSum(sum-value) ?: false || right?.pathSum(sum-value) ?: false
}

// For practice defining a tree
private data class MyTreeNode(val value: Int, val left: MyTreeNode?=null, val right: MyTreeNode?=null)

class PathSumKotlin {

    @Test
    fun example1() {

        val tree = MyTreeNode(
            5,
            MyTreeNode(
                4,
                MyTreeNode(
                    11,
                    MyTreeNode(
                        7
                    ),
                    MyTreeNode(
                        2
                    )
                )
            ),
            MyTreeNode(
                8,
                MyTreeNode(13),
                MyTreeNode(4,
                    null,
                    MyTreeNode(1)
                )
            )
        )
        assertThat(tree.pathSum(22)).isTrue
        assertThat(tree.pathSum(26)).isTrue
        assertThat(tree.pathSum(18)).isTrue
        assertThat(tree.pathSum(19)).isFalse
    }
}