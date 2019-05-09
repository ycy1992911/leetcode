package utils;

import java.util.List;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-09
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
