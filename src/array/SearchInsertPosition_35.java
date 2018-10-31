package array;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 * @author yancy3@lenovo.com
 * @date 31/10/2018
 */
public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int lo = 0;
        int hi = nums.length;
        int mid = 0;
        while (lo < hi - 1) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid;
            } else if (nums[mid] < target) {
                lo = mid;
            } else {
                return mid;
            }
        }
        if (nums[mid] < target) {
            return mid + 1;
        } else {
            return mid;
        }
    }
}
