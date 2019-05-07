package tree;

import java.util.HashSet;
import java.util.Set;
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
     * @param tree
     * @param L
     * @param R
     * @return
     */
    int rangeSumBST(TreeNode tree, int L, int R) {
        if (tree.left == null && tree.right == null) {
            return tree.val > L && tree.val < R ? tree.val : -1;
        }

        return sum(getValueListFromTree(tree, L, R));
    }

    private int sum(Set<Integer> valueList) {
        return valueList.stream().reduce(Integer::sum).orElse(0);
    }

    private Set<Integer> getValueListFromTree(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        Set<Integer> values = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            if (head.val >= L && head.val <= R) {
                values.add(head.val);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }

        return values;
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

        return node.val + rangeSumTree(node.left, L, R) + rangeSumTree(node.right, L, R);
    }
}
