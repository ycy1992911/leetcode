package string;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author yancy3@lenovo.com
 * @date 31/10/2018
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        Queue<Character> queue = new ArrayDeque<>();
        char[] cha = s.toCharArray();

        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!queue.contains(cha[i])) {
                queue.add(cha[i]);
                count++;
            } else {
                max = max > count ? max : count;
                while (queue.poll() != cha[i]) {
                    count--;
                }
                queue.add(cha[i]);
            }
        }
        return max > count ? max : count;
    }
}
