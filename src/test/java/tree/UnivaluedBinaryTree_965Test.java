package tree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static utils.CollectionGeneratorFactory.createBinarySearchTree_1111111;
import static utils.CollectionGeneratorFactory.createBinarySearchTree_12345678;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-17
 */
@ExtendWith(MockitoExtension.class)
class UnivaluedBinaryTree_965Test {
    private TreeNode root;

    @Spy
    private UnivaluedBinaryTree_965 ubt;

    @Test
    void should_return_false_when_input_is_null() {
        // given
        root = null;
        // when
        boolean res = ubt.isUnivalTree(null);
        // verify
        assertFalse(res);
    }

    @Test
    void should_return_false() {
        //give
        root = createBinarySearchTree_12345678();

        //when
        boolean res = ubt.isUnivalTree(root);
        //verify
        verify(ubt, times(1)).isUnivalTree(any());
        assertFalse(res);
    }

    @Test
    void should_return_true() {
        //give
        root = createBinarySearchTree_1111111();
        //when
        boolean res = ubt.isUnivalTree(root);
        //verify
        assertTrue(res);
    }

}