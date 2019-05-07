package tree;

import java.util.Stack;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-07
 */
public class RangeSumOfBST_938 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * non recursive
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val > L && root.val < R ? root.val : -1;
        }

        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            if (head.val >= L && head.val <= R) {
                sum += head.val;
            }
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }

        return sum;
    }

    /**
     * recursive
     *
     * @param node
     * @param L
     * @param R
     * @return
     */
    int rangeSumTree(TreeNode node, int L, int R) {
        if (node == null) {
            return 0;
        }
        if (node.val < L) {
            return rangeSumTree(node.right, L, R);
        }
        if (node.val > R) {
            return rangeSumTree(node.left, L, R);
        }

        return node.val + rangeSumBST(node.right, L, R) + rangeSumBST(node.left, L, R);
    }
}
