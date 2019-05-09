package tree;

import utils.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-09
 */
public class nAryTreePreorderTraversal_589 {
    public List<Integer> preOrderNonRecursive(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.children != null && !root.children.isEmpty()) {
                for (int i = root.children.size() - 1; i >= 0; i--) {
                    stack.push(root.children.get(i));
                }
            }
        }

        return res;
    }

    public List<Integer> preOrderRecursive(Node root) {
        List<Integer> res = new ArrayList<>();
        runRecursive(res, root);
        return res;
    }

    private void runRecursive(List<Integer> res, Node root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        if (root.children != null && !root.children.isEmpty()) {
            root.children.forEach(node -> runRecursive(res, node));
        }
    }
}
