package tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNodeWithMultiChildren;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-13
 */
class nAryTreePostorderTraversal_590Test {
    nAryTreePostorderTraversal_590 traversal = new nAryTreePostorderTraversal_590();
    TreeNodeWithMultiChildren threeFirstChild;
    TreeNodeWithMultiChildren threeSecondChild;
    TreeNodeWithMultiChildren three;
    TreeNodeWithMultiChildren two;
    TreeNodeWithMultiChildren four;
    TreeNodeWithMultiChildren root;

    @BeforeEach
    void setUp() {
        threeFirstChild = new TreeNodeWithMultiChildren(5, null);
        threeSecondChild = new TreeNodeWithMultiChildren(6, null);
        three = new TreeNodeWithMultiChildren(3, Arrays.asList(threeFirstChild, threeSecondChild));
        two = new TreeNodeWithMultiChildren(2, null);
        four = new TreeNodeWithMultiChildren(4, null);
        root = new TreeNodeWithMultiChildren(1, Arrays.asList(three, two, four));
    }

    // null
    @Test
    void should_return_empty_array() {
        root = null;
        assertEquals(new ArrayList<Integer>(), traversal.postorderRecursive(root));
    }

    // 563241
    @Test
    void should_return_5_6_3_2_4_1() {
        List<Integer> res = Arrays.asList(5, 6, 3, 2, 4, 1);
        assertEquals(res, traversal.postorderRecursive(root));
    }
}