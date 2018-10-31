package array;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * @author yancy3@lenovo.com
 * @date 31/10/2018
 */
public class SortArrayByParity_905 {
    public int[] sortArrayByParity(int[] A) {
        // priory condition
        if (A == null || A.length == 0) {
            return new int[]{};
        }

        // int array to return
        int[] res = new int[A.length];
        int left = 0;
        int right = res.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[left++] = A[i];
            } else {
                res[right--] = A[i];
            }
        }

        return res;
    }
}
