package array;

/**
 * @author yancy3@lenovo.com
 * created on 2019-03-04
 */
public class ReverseInteger_7 {

    public int reverseInterger(int x) {
        char[] num = String.valueOf(x).toCharArray();
        StringBuilder sb = new StringBuilder(num.length);
        if (num[0] == '-') {
            sb.append('-');
            reverse(num, sb, false);
        } else {
            reverse(num, sb, true);
        }

        try {
            Integer.valueOf(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }

        return Integer.valueOf(sb.toString());
    }

    private void reverse(char[] num, StringBuilder sb, boolean isNegative) {
        int min = isNegative ? 0 : 1;
        for (int i = num.length - 1; i >= min; i--) {
            sb.append(num[i]);
        }
    }

}
