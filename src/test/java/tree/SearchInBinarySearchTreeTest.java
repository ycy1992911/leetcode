package tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-08
 */
class SearchInBinarySearchTreeTest {
    SearchInBinarySearchTree searchTree;

    @BeforeEach
    void setUp() {
        searchTree = new SearchInBinarySearchTree();
    }

    @Test
    void should_return_a_subtree_2_1_3() {
        // expected result
        TreeNode subtree = new TreeNode(2);
        subtree.left = new TreeNode(1);
        subtree.right = new TreeNode(3);

        // input
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        int val = 2;

        TreeNode recursiveRes = searchTree.searchBST(root, val);
        assertEquals(2, recursiveRes.val);
        assertEquals(1, recursiveRes.left.val);
        assertEquals(3, recursiveRes.right.val);

        TreeNode nonRecursiveRes = searchTree.searchBSTNonRecursive(root, val);
        assertEquals(2, nonRecursiveRes.val);
        assertEquals(1, nonRecursiveRes.left.val);
        assertEquals(3, nonRecursiveRes.right.val);
    }

    @Test
    void can_not_find_five() {
        // expected result
        TreeNode subtree = new TreeNode(2);
        subtree.left = new TreeNode(1);
        subtree.right = new TreeNode(3);

        // input
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        int val = 5;

        TreeNode nonRecursiveRes = searchTree.searchBST(root, val);
        assertNull(nonRecursiveRes);

        TreeNode recursiveRes = searchTree.searchBSTNonRecursive(root, val);
        assertNull(recursiveRes);
    }

    @Test
    void can_not_find_eight() {
        // expected result
        TreeNode subtree = new TreeNode(2);
        subtree.left = new TreeNode(1);
        subtree.right = new TreeNode(3);

        // input
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        int val = 8;

        TreeNode nonRecursiveRes = searchTree.searchBST(root, val);
        assertNull(nonRecursiveRes);

        TreeNode recursiveRes = searchTree.searchBSTNonRecursive(root, val);
        assertNull(recursiveRes);
    }
}