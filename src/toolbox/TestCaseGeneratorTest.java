package toolbox;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author chongyang18@gmail.com
 * @date 13/04/2018
 */
public class TestCaseGeneratorTest {

    @Test
    public void treeFromOneToSize() {
        int size = 10;
        TestCaseGenerator.TreeNode head = TestCaseGenerator.treeFromOneToSize(size);
        int[] res = new int[size];

        // 层次遍历并记录入数组
        Queue<TestCaseGenerator.TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TestCaseGenerator.TreeNode node = queue.poll();
            res[node.val - 1] = node.val;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, res);
    }

}