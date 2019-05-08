package tree;

import utils.TreeNode;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-08
 */
public class SearchInBinarySearchTree {
    TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }

    TreeNode searchBSTNonRecursive(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                break;
            }
            if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
