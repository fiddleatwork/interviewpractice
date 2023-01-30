package coding.educative.patterns.depthfirst;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PathSumJava {

    private class MyTreeNode {
        private int value;
        private MyTreeNode left;
        private MyTreeNode right;

        public MyTreeNode(int value, MyTreeNode left, MyTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private boolean pathSum(MyTreeNode node, int sum) {
        if(node.left == null && node.right== null) {
            return node.value == sum;
        }
        return node.left != null && pathSum(node.left, sum-node.value) ||
                node.right != null && pathSum(node.right, sum-node.value);
    }

    @Test
    public void example1() {
        MyTreeNode tree = new MyTreeNode(
                5,
                new MyTreeNode(
                        4,
                        new MyTreeNode(
                                11,
                                new MyTreeNode(7, null, null),
                                new MyTreeNode(2, null, null)
                        ),
                        null
                ),
                new MyTreeNode(
                        8,
                        new MyTreeNode(13, null, null),
                        new MyTreeNode(4,
                                null,
                                new MyTreeNode(1, null, null)
                        )
                )
        );
        assertThat(pathSum(tree, 22)).isTrue();
        assertThat(pathSum(tree, 26)).isTrue();
        assertThat(pathSum(tree, 18)).isTrue();
        assertThat(pathSum(tree, 19)).isFalse();
    }
}
