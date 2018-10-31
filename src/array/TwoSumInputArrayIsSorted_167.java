package array;

/**
 * @author yancy3@lenovo.com
 * @date 31/10/2018
 */
public class TwoSumInputArrayIsSorted_167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;

        while (numbers[left] + numbers[right] != target) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }
        res[0] = left + 1;
        res[1] = right + 1;

        return res;
    }
}
