package toolbox;

import com.chunks.mylib.TestCaseGenerator.Node;
import com.chunks.mylib.TestCaseGenerator.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author chongyang18@gmail.com
 * @date 13/04/2018
 */
public class OperationGeneratorTest {
    /**
     * 声明（为null）：输出流 (字符设备) console
     */
    private PrintStream console = null;
    /**
     * 声明（为null）：bytes 用于缓存console 重定向过来的字符流
     */
    private ByteArrayOutputStream bytes = null;

    /**
     * 声明（为null）：期望打印输出
     */
    private String descString;
    private String ascString;

    @Before
    public void setUp() throws Exception {
        // 分配空间
        bytes = new ByteArrayOutputStream();
        // 获取System.out 输出流的句柄
        console = System.out;
        // 将原本输出到控制台Console的字符流 重定向 到 bytes
        System.setOut(new PrintStream(bytes));
        // 设置目标输出
        descString = "10 9 8 7 6 5 4 3 2 1 ";
        ascString = "1 2 3 4 5 6 7 8 9 10 ";
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }

    @Test
    public void reverseSingleLinkedListRecursively() {
        Node head = TestCaseGenerator.linkedListFromOneToLength(10);
        Node newHead = OperationGenerator.reverseSingleLinkedListRecursively(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        assertEquals(descString, bytes.toString());
    }

    @Test
    public void reverseSingleLinkedListUnRecur() {
        Node head = TestCaseGenerator.linkedListFromOneToLength(10);
        Node newHead = OperationGenerator.reverseSingleLinkedListUnRecur(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        assertEquals(descString, bytes.toString());
    }

    @Test
    public void preOrderTraverseBinaryTreeUnRecur() {
        TreeNode root = TestCaseGenerator.treeFromOneToSize(10);
        OperationGenerator.preOrderTraverseBinaryTreeUnRecur(root);
        assertEquals("1 2 4 8 9 5 10 3 6 7 ", bytes.toString());
    }

    @Test
    public void inOrderTraverseBinaryTreeUnRecur() {
        TreeNode root = TestCaseGenerator.treeFromOneToSize(10);
        OperationGenerator.inOrderTraverseBinaryTreeUnRecur(root);
        assertEquals("8 4 9 2 10 5 1 6 3 7 ", bytes.toString());
    }

    @Test
    public void postOrderTraverseBinaryTreeUnRecur() {
        TreeNode root = TestCaseGenerator.treeFromOneToSize(10);
        OperationGenerator.postOrderTraverseBinaryTreeUnRecur(root);
        assertEquals("8 9 4 10 5 2 6 7 3 1 ", bytes.toString());
    }

    @Test
    public void preOrderTraverseBinaryTreeRecursively() {
        TreeNode root = TestCaseGenerator.treeFromOneToSize(10);
        OperationGenerator.preOrderTraverseBinaryTreeRecursively(root);
        assertEquals("1 2 4 8 9 5 10 3 6 7 ", bytes.toString());
    }

    @Test
    public void inOrderTraverseBinaryTreeRecursively() {
        TreeNode root = TestCaseGenerator.treeFromOneToSize(10);
        OperationGenerator.inOrderTraverseBinaryTreeRecursively(root);
        assertEquals("8 4 9 2 10 5 1 6 3 7 ", bytes.toString());
    }

    @Test
    public void postOrderTraverseBinaryTreeRecursively() {
        TreeNode root = TestCaseGenerator.treeFromOneToSize(10);
        OperationGenerator.postOrderTraverseBinaryTreeRecursively(root);
        assertEquals("8 9 4 10 5 2 6 7 3 1 ", bytes.toString());
    }

    @Test
    public void hierarchicalTraverseBinaryTree() {
        TreeNode root = TestCaseGenerator.treeFromOneToSize(10);
        OperationGenerator.hierarchicalTraverseBinaryTree(root);
        assertEquals(ascString, bytes.toString());
    }

    @Test
    public void topKNumbers() {
        int k = 100;
        int[] arr = TestCaseGenerator.randomIntArray(1000);
        int[] topKArr = OperationGenerator.topKNumbers(arr, k);

        Arrays.sort(arr);
        int[] sortArr = new int[k];
        System.arraycopy(arr, 0, sortArr, 0, k);
        assertArrayEquals(sortArr, topKArr);
    }

    @Test
    public void heapSink() {
        int[] arr = new int[]{1, 5, 3, 2, 4};
        OperationGenerator.heapSink(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arr);
    }

    @Test
    public void swapIntArray() {
        int size = 10000;
        int[] arr = TestCaseGenerator.randomIntArray(size);
        int[] tempArr = new int[arr.length];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        for (int i = 0; i < size; i++) {
            int a = new Random().nextInt(size);
            int b = new Random().nextInt(size);
            OperationGenerator.swapIntArray(arr, a, b);
            OperationGenerator.swapIntArray(arr, a, b);
        }
        assertArrayEquals(tempArr, arr);
    }

    @Test
    public void binarySearchFindIndex() {
        int resFound = OperationGenerator.binarySearchFindIndex(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 9, 10);
        int resNotFound = OperationGenerator.binarySearchFindIndex(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 9, 11);
        assertEquals(9, resFound);
        assertEquals(-1, resNotFound);
    }

    @Test
    public void binarySearchIsFound() {
        assertTrue(OperationGenerator.binarySearchIsFound(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 9, 10));
    }
}