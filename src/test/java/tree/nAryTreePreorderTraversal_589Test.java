package tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNodeWithMultiChildren;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-09
 */
class nAryTreePreorderTraversal_589Test {
    nAryTreePreorderTraversal_589 traversal;

    @BeforeEach
    void setUp() {
        traversal = new nAryTreePreorderTraversal_589();
    }

    @Test
    void should_return_1_3_5_6_2_4() {
        TreeNodeWithMultiChildren threeFirstChild = new TreeNodeWithMultiChildren(5, null);
        TreeNodeWithMultiChildren threeSecondChild = new TreeNodeWithMultiChildren(6, null);
        TreeNodeWithMultiChildren three = new TreeNodeWithMultiChildren(3, Arrays.asList(threeFirstChild, threeSecondChild));
        TreeNodeWithMultiChildren two = new TreeNodeWithMultiChildren(2, null);
        TreeNodeWithMultiChildren four = new TreeNodeWithMultiChildren(4, null);
        TreeNodeWithMultiChildren root = new TreeNodeWithMultiChildren(1, Arrays.asList(three, two, four));

        List<Integer> res = Arrays.asList(1, 3, 5, 6, 2, 4);

        assertEquals(res, traversal.preOrderNonRecursive(root));
//        assertEquals(res, traversal.preOrderRecursive(root));
    }
}