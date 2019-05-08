package tree;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Example:
 * <p>
 * You may serialize the following tree:
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 * @author yancy3@lenovo.com
 * @date 31/10/2018
 */
public class SerializeAndDeserializeBinaryTree_297 {

    /**
     * Encodes a tree to a single string
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> que = new ArrayDeque<>();
        Queue<String> resQue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        que.add(root);
        int index = 1;
        int count = 1;
        resQue.add(String.valueOf(root.val));
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            count--;
            if (node.left != null) {
                que.add(node.left);
                resQue.add(String.valueOf(node.left.val));
            } else {
                resQue.add("null");
            }
            if (node.right != null) {
                que.add(node.right);
                resQue.add(String.valueOf(node.right.val));
            } else {
                resQue.add("null");
            }

            if (count == 0) {
                while (!resQue.isEmpty()) {
                    sb.append(resQue.poll());
                    sb.append(",");
                }
                index *= 2 + 1;
                count = index;
            }
        }

        while (!resQue.isEmpty()) {
            sb.append(resQue.poll());
            sb.append(",");
        }
        String[] ans = sb.deleteCharAt(sb.length() - 1).toString().split(",");
        sb = new StringBuilder();
        int i = ans.length - 1;
        while ("null".equals(ans[i])) {
            i--;
        }

        for (int j = 0; j <= i; j++) {
            sb.append(ans[j]);
            sb.append(",");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    /**
     * Decodes the encoded data to tree.
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        Queue<TreeNode> que = new ArrayDeque<>();
        String[] str = data.split(",");
        if (data.length() == 3) {
            TreeNode root = new TreeNode(Integer.valueOf(str[0]));
            root.left = new TreeNode(Integer.valueOf(str[1]));
            return root;
        }

        String nll = "null";
        TreeNode root = null;
        if (!nll.equals(str[0])) {
            root = new TreeNode(Integer.valueOf(str[0]));
            que.add(root);
            int maxIndex = str.length / 2 - 1;
            for (int i = 0; i <= maxIndex; i++) {
                TreeNode node = que.poll();
                if ((i + 1) * 2 - 1 < str.length && !nll.equals(str[((i + 1) * 2) - 1])) {
                    node.left = new TreeNode(Integer.valueOf(str[((i + 1) * 2) - 1]));
                    que.add(node.left);
                }
                if ((i + 1) * 2 < str.length && !nll.equals(str[(i + 1) * 2])) {
                    node.right = new TreeNode(Integer.valueOf(str[(i + 1) * 2]));
                    que.add(node.right);
                }
            }
        }
        return root;
    }
}
