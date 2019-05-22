package tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-07
 */
class RangeSumOfBST_938Test {

    private RangeSumOfBST_938 solution;
    private int L;
    private int R;

    private TreeNode buildBinarySearchTree(List<Integer> nodeValues) {
        List<TreeNode> nodes = nodeValues.stream().filter(Objects::nonNull).map(TreeNode::new).collect(Collectors.toList());
        Queue<TreeNode> parents = new ArrayDeque<>(nodes);

        TreeNode bstRoot;
        parents.add(nodes.get(0));
        int index = 1;
        while (!parents.isEmpty() && index < nodes.size()) {
            bstRoot = parents.poll();
            TreeNode left = nodes.get(index++);
            bstRoot.left = left;
            if (left != null) {
                parents.add(left);
            }

            if (index >= nodes.size()) {
                break;
            }
            TreeNode right = nodes.get(index++);
            bstRoot.right = right;
            if (right != null) {
                parents.add(right);
            }
        }

        return nodes.get(0);
    }

    private List preTraversalBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode head = stack.pop();
            res.add(head.val);
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }

        return res;
    }

    @BeforeEach
    void setUp() {
        solution = new RangeSumOfBST_938();
    }

    @Test
    void binary_search_tree_should_be_one_to_ten() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expect = Arrays.asList(1, 2, 4, 8, 9, 5, 10, 3, 6, 7);

        TreeNode root = buildBinarySearchTree(input);
        assertEquals(expect, preTraversalBST(root));
    }

    @Test
    void should_return_thirty_two() {
        List<Integer> list = Arrays.asList(10, 5, 15, 3, 7, null, 18);
        L = 7;
        R = 15;

        TreeNode root = buildBinarySearchTree(list);
        assertEquals(32, solution.rangeSumBST(root, L, R));
        assertEquals(32, solution.rangeSumTree(root, L, R));
    }

    @Test
    void should_return_twenty_three() {
        List<Integer> list = Arrays.asList(10, 5, 15, 3, 7, 13, 18, 1, null, 6);
        L = 6;
        R = 10;

        TreeNode root = buildBinarySearchTree(list);
        assertEquals(23, solution.rangeSumTree(root, L, R));
        assertEquals(23, solution.rangeSumBST(root, L, R));
    }
}