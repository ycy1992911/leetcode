package array;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * 本题解法时间复杂度：O(n^2 + NLogN)，空间复杂度O(N) (只用了一个Set作为辅助)
 * @author chongyang18@gmail.com
 * @date 28/01/2018
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> listSet = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int gap = 0 - nums[i];
            int head = i + 1;
            int tail = nums.length - 1;

            while (tail > head) {
                if (nums[head] + nums[tail] > gap) {
                    tail -= 1;
                } else if (nums[head] + nums[tail] < gap) {
                    head += 1;
                } else {
                    list.add(nums[i]);
                    list.add(nums[head]);
                    list.add(nums[tail]);
                    listSet.add(list);
                    list = new ArrayList<>();
                    break;
                }

            }
        }
        return listSet;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }
}
