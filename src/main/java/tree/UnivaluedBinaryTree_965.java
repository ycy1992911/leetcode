package tree;

import utils.TreeNode;

import java.util.Stack;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-17
 */
public class UnivaluedBinaryTree_965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        int instant = root.val;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val != instant) {
                return false;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return true;
    }
}
