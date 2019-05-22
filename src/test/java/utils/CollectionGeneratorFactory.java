package utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-17
 */
public class CollectionGeneratorFactory {
    private CollectionGeneratorFactory() {
    }

    public static TreeNode createBinarySearchTree_1111111() {
        return buildBinarySearchTreeByList(Arrays.asList(1, 1, 1, 1, 1, 1, 1));
    }

    public static TreeNode createBinarySearchTree_12345678() {
        return buildBinarySearchTreeByList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
    }

    public static TreeNode buildBinarySearchTreeByList(List<Integer> nodeValues) {
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

    public static TreeNodeWithMultiChildren createTreeWithMultiChildren_135624() {
        TreeNodeWithMultiChildren threeFirstChild = new TreeNodeWithMultiChildren(5, null);
        TreeNodeWithMultiChildren threeSecondChild = new TreeNodeWithMultiChildren(6, null);
        TreeNodeWithMultiChildren three = new TreeNodeWithMultiChildren(3, Arrays.asList(threeFirstChild, threeSecondChild));
        TreeNodeWithMultiChildren two = new TreeNodeWithMultiChildren(2, null);
        TreeNodeWithMultiChildren four = new TreeNodeWithMultiChildren(4, null);
        TreeNodeWithMultiChildren root = new TreeNodeWithMultiChildren(1, Arrays.asList(three, two, four));
        return root;
    }
}
