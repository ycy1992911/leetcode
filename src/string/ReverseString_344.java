package string;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example 1:
 * <p>
 * Input: "hello"
 * Output: "olleh"
 * Example 2:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 *
 * @author yancy3@lenovo.com
 * @date 31/10/2018
 */
public class ReverseString_344 {
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = word.length - 1;
        while (i < j) {
            char temp = word[j];
            word[j] = word[i];
            word[i] = temp;
            i++;
            j--;
        }
        return new String(word);
    }
}
