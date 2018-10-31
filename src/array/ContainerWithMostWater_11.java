package array;

/**
 * 两边向中间逼近
 *
 * @author chongyang18@gmail.com
 * @date 31/05/2018
 */
public class ContainerWithMostWater_11 {
    private static int maxArea(int[] height) {
        int maxSize = 0;
        int head = 0;
        int tail = height.length - 1;
        while (head < tail) {
            int currentHeight = height[head] < height[tail] ? height[head] : height[tail];
            int currentWidth = tail - head;
            int currentSize = currentWidth * currentHeight;
            maxSize = currentSize > maxSize ? currentSize : maxSize;
            // 逼近过程中，宽度在缩小，所以保留较高的那一个边
            if (currentHeight == height[head]) {
                head++;
            } else {
                tail--;
            }

        }

        return maxSize;
    }
}
