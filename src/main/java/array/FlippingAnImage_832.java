package array;

/**
 * @author yancy3@lenovo.com
 * created on 2019-05-22
 */
public class FlippingAnImage_832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] B = new int[A.length][];

        for (int i = 0; i < A.length; i++) {
            int[] segment = new int[A[i].length];
            for (int j = 0; j < A[i].length; j++) {
                segment[segment.length - 1 - j] = Math.abs(A[i][j] - 1);
            }
            B[i] = segment;
        }

        return B;
    }
}
