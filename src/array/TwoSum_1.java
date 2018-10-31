package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author yancy3@lenovo.com
 * @date 31/10/2018
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        int[] arr = new int[]{-1, -1};
        for (int i = 0; i <= nums.length - 1; i++) {
            int temp = target - nums[i];
            if (!set.contains(temp)) {
                set.add(nums[i]);
            } else {
                arr[1] = i;
                for (int j = 0; j < i; j++) {
                    if (nums[j] == temp) {
                        arr[0] = j;
                        break;
                    }
                }
            }
        }
        return arr;
    }
}
