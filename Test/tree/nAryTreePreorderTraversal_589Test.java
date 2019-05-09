package tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Node;

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
        Node threeFirstChild = new Node(5, null);
        Node threeSecondChild = new Node(6, null);
        Node three = new Node(3, Arrays.asList(threeFirstChild, threeSecondChild));
        Node two = new Node(2, null);
        Node four = new Node(4, null);
        Node root = new Node(1, Arrays.asList(three, two, four));

        List<Integer> res = Arrays.asList(1, 3, 5, 6, 2, 4);

        assertEquals(res, traversal.preOrderNonRecursive(root));
//        assertEquals(res, traversal.preOrderRecursive(root));
    }
}