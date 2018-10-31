package toolbox;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/**
 * This is a class to generate different test cases including things like an array full of random numbers,
 * a linkedList, a tree and etc
 *
 * @author chongyang18@gmail.com
 * @date 13/04/2018
 */
public class TestCaseGenerator {
    /**
     * for linkedList creation
     */
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * for tree creation
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * create a linkedList start with 1 to length
     *
     * @param length length of the array
     * @return a linkedList
     */
    public static Node linkedListFromOneToLength(int length) {
        Node head = new Node(1);
        Node tempHead = head;
        for (int i = 2; i <= length; i++) {
            tempHead.next = new Node(i);
            tempHead = tempHead.next;
        }
        return head;
    }

    /**
     * create an int array with random numbers
     *
     * @param size size of the array
     * @return the array
     */
    public static int[] randomIntArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(arr.length - 1) - new Random().nextInt(arr.length - 1);
        }
        return arr;
    }

    /**
     * create a tree from one to size
     *
     * @param size tree size
     * @return root of the tree
     */
    public static TreeNode treeFromOneToSize(int size) {
        Queue<TreeNode> heads = new ArrayDeque<>(10);
        Queue<TreeNode> cache = new ArrayDeque<>(10);
        for (int i = 1; i <= size; i++) {
            TreeNode head = new TreeNode(i);
            heads.add(head);
            if (i != 1) {
                cache.add(head);
            }
        }

        TreeNode head = heads.poll();
        TreeNode subHead = head;
        while (!cache.isEmpty()) {
            subHead.left = cache.poll();
            if (!cache.isEmpty()) {
                subHead.right = cache.poll();
                subHead = heads.poll();
            }
        }
        return head;
    }
}
