package toolbox;

import com.chunks.mylib.TestCaseGenerator.Node;
import com.chunks.mylib.TestCaseGenerator.TreeNode;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * this class includes operations on different data structures e.g reverse a single linkedList
 *
 * @author chongyang18@gmail.com
 * @date 13/04/2018
 */
@SuppressWarnings("Duplicates")
public class OperationGenerator {

    /**
     * recursively reverse a single linkedList
     *
     * @param head head of the initial list
     * @return head of the reversed list
     */
    public static Node reverseSingleLinkedListRecursively(Node head) {
        if (head.next == null) {
            return head;
        }

        Node newHead = reverseSingleLinkedListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * iteratively reverse a single linkedList
     *
     * @param head head of the initial list
     * @return head of the reversed list
     */
    @SuppressWarnings("Duplicates")
    public static Node reverseSingleLinkedListUnRecur(Node head) {
        Node pre = null;
        Node cur = head;

        while (cur.next != null) {
            Node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        cur.next = pre;
        return cur;
    }

    /**
     * pre-order traverse and print a binary tree un-recursively
     *
     * @param root root of the tree
     */
    public static void preOrderTraverseBinaryTreeUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode subRoot = stack.pop();
            System.out.print(subRoot.val + " ");
            if (subRoot.right != null) {
                stack.push(subRoot.right);
            }
            if (subRoot.left != null) {
                stack.push(subRoot.left);
            }
        }
    }

    /**
     * in-order traverse a binary tree
     * 左右中(l-r-m)
     *
     * @param root root of the tree
     */
    public static void inOrderTraverseBinaryTreeUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode subRoot = stack.pop();
                System.out.print(subRoot.val + " ");
                root = subRoot.right;
            }
        }

    }

    /**
     * pOST-order traverse a binary tree
     *
     * @param root root of the tree
     */
    public static void postOrderTraverseBinaryTreeUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }

        // a stack with mid-right-left order
        Stack<TreeNode> mrlStack = new Stack<>();
        // a stack with left-right-mid (reverse mid-right-left) order
        Stack<TreeNode> stack = new Stack<>();

        //push the tree into mrlStack
        mrlStack.push(root);
        while (!mrlStack.isEmpty()) {
            TreeNode subRoot = mrlStack.pop();
            // record the mid-right-left order into stack
            stack.push(subRoot);
            if (subRoot.left != null) {
                mrlStack.push(subRoot.left);
            }
            if (subRoot.right != null) {
                mrlStack.push(subRoot.right);
            }

        }

        // take elements back with an order of left-right-mid
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + " ");
        }
    }

    /**
     * hierarchical traverse a binary tree
     *
     * @param root root of the tree
     */
    public static void hierarchicalTraverseBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode subRoot = queue.poll();
            System.out.print(subRoot.val + " ");
            if (subRoot.left != null) {
                queue.add(subRoot.left);
            }
            if (subRoot.right != null) {
                queue.add(subRoot.right);
            }
        }
    }

    /**
     * pre-order traverse a binary tree recursively
     *
     * @param root root of the tree
     */
    public static void preOrderTraverseBinaryTreeRecursively(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preOrderTraverseBinaryTreeRecursively(root.left);
        preOrderTraverseBinaryTreeRecursively(root.right);
    }

    /**
     * in-order traverse a binary tree recursively
     *
     * @param root root of the tree
     */
    public static void inOrderTraverseBinaryTreeRecursively(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraverseBinaryTreeRecursively(root.left);
        System.out.print(root.val + " ");
        inOrderTraverseBinaryTreeRecursively(root.right);
    }

    /**
     * post-order traverse a binary tree recursively
     *
     * @param root root of the tree
     */
    public static void postOrderTraverseBinaryTreeRecursively(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderTraverseBinaryTreeRecursively(root.left);
        postOrderTraverseBinaryTreeRecursively(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * find the minimum k numbers in an int array
     *
     * @param data the array
     * @param k    the minimum k numbers
     * @return an array contains the minimum k numbers
     */
    public static int[] topKNumbers(@NotNull int[] data, int k) {
        // create a heap contains k elements
        int[] heap = new int[k];
        System.arraycopy(data, 0, heap, 0, k);

        // heapify
        int len = heap.length - 1;
        for (int i = len / 2; i > -1; i--) {
            heapSink(heap, i, len);
        }

        // find the k minimum numbers
        for (int m = k; m < data.length; m++) {
            if (data[m] < heap[0]) {
                heap[0] = data[m];
                heapSink(heap, 0, heap.length - 1);
            }
        }
        Arrays.sort(heap);

        return heap;
    }

    /**
     * sink the element at index in the heap
     *
     * @param arr   the heap
     * @param index where to start sinking
     * @param len   max index of the heap
     */
    @SuppressWarnings("Duplicates")
    public static void heapSink(@NotNull int[] arr, int index, int len) {
        while (2 * index + 1 <= len) {
            int left = 2 * index + 1;
            if (left + 1 <= len && arr[left] < arr[left + 1]) {
                left++;
            }
            if (arr[index] > arr[left]) {
                break;
            }
            swapIntArray(arr, index, left);
            index = left;
        }
    }


    /**
     * swap two elements in an array
     *
     * @param arr       array
     * @param positionA position of the first element
     * @param positionB position of the second element
     */
    public static void swapIntArray(@NotNull int[] arr, int positionA, int positionB) {
        int temp = arr[positionA];
        arr[positionA] = arr[positionB];
        arr[positionB] = temp;
    }

    /**
     * binary search
     *
     * @param arr array to search within
     * @param target target number
     * @return target index in array
     */
    @SuppressWarnings("Duplicates")
    public static int binarySearchFindIndex(int[] arr, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if(arr[mid] > target) {
                hi = mid - 1;
            }else if(arr[mid] < target) {
                lo = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * binary search
     *
     * @param arr array to search within
     * @param target target number
     * @return if is found
     */
    public static boolean binarySearchIsFound(int[] arr, int lo, int hi, int target) {
        return binarySearchFindIndex(arr, lo, hi, target) != -1;
    }
}
