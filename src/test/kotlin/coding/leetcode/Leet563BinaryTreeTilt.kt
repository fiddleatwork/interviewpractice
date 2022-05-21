package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

//data class TreeNode(var `val`: Int, val left: TreeNode? = null, val right: TreeNode? = null)

class Leet563BinaryTreeTilt {

    data class TiltData(val tiltSum: Int, val valueSum: Int)

    fun findTilt(root: TreeNode?): Int {
        return findTiltData(root, TiltData(0, 0)).tiltSum
    }

    private fun findTiltData(root: TreeNode?, data: TiltData): TiltData {
        if (root == null) {
            return TiltData(data.tiltSum, data.valueSum)
        }
        val left = findTiltData(root.left, data)
        val right = findTiltData(root.right, data)
        val middleTilt = Math.abs(left.valueSum - right.valueSum)
        val middleValueSum = root.`val` + left.valueSum + right.valueSum
        val middleTiltSum = middleTilt + left.tiltSum + right.tiltSum
        return TiltData(middleTiltSum, middleValueSum)
    }

    @Test
    fun example1() {
        val root = TreeNode(1, TreeNode(2, null, null), TreeNode(3, null, null))
        assertThat(findTilt(root)).isEqualTo(1)
    }

    @Test
    fun example2() {
        val root = TreeNode(
            4,
            TreeNode(2, TreeNode(3), TreeNode(5)),
            TreeNode(9, null, TreeNode(7))
        )
        assertThat(findTilt(root)).isEqualTo(15)
    }
}