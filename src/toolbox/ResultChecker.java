package toolbox;

import com.chunks.mylib.TestCaseGenerator.Node;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * @author chongyang18@gmail.com
 * @date 13/04/2018
 */
public class ResultChecker {
    /**
     * print the linkedList
     *
     * @param node head of the linkedList
     */
    public static void linkedListPrinter(Node node) {
        if (node == null) {
            System.out.print("null");
            return;
        }

        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) {
                System.out.print("->");
            }
        }
    }

    /**
     * exam if two arrays contains same elements in the same order
     *
     * @param a array a
     * @param b array b
     * @return if two arrays are equal
     */
    public static boolean isIntArrayEqual(@NotNull int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * exam if the array is sorted into ascending numerical order
     *
     * @param arr array to be check
     * @return if is sorted
     */
    public static boolean isIntArraySorted(@NotNull int[] arr) {
        if(arr.length == 1) {
            return true;
        }

        int[] tempArr = new int[arr.length];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        Arrays.sort(tempArr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != tempArr[i]) {
                return false;
            }
        }
        return true;
    }
}
