package subject8;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/30/15:48
 * @Description:
 */
public class Solution2 {
    public int myAtoi(String s) {
        int length = s.length();
        if (length == 0) return 0;
        //是否是正数（默认正数1）
        int sign = 1;
        int i = 0;
        int res = 0;
        if (s.charAt(i) == ' ') {
            while (i<length && s.charAt(i) == ' ') {
                i++;
            }
        }   //读取空格字符
        if (i<length && s.charAt(i) == '+' ) {
            sign = 1;
            i++;
        } else if (i<length && s.charAt(i) == '-'){
            sign = -1;
            i++;
        }   //读取正负字符
        if (i<length && s.charAt(i)>='0' && s.charAt(i)<='9'){
            while (i<length&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (s.charAt(i) - '0') > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (s.charAt(i) - '0') > -(Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + sign * (s.charAt(i) - '0');
                i++;
            }
        }   //读取数字字符
        return res;
    }
}
