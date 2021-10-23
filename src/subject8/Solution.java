package cn.fangaoxs.day18.subject8;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/05/23:42
 * @Description:
 */
public class Solution {
    public static int myAtoi(String s) {
        int length = s.length();
        if (length == 0) return 0;
        int res = 0;                //初始化返回值
        int i = 0;                  //遍历字符的下标
        int sign = 1;               //结果的正负（默认为正）
        if (s.charAt(i) == ' ') {   //从起始开始判断，如果为' '空格则i一直循环，直至没有空格
            while (i<length&&s.charAt(i) == ' '){
                i++;
            }
        }  //读取空格字符
        if (i<length&&s.charAt(i) == '-' ) {
            sign = -1;
            i+=1;
        } else if (i<length&&s.charAt(i) == '+') {
            sign = 1;
            i+=1;
        }  //读取正负字符
        if (i<length&&s.charAt(i)>='0'&&s.charAt(i)<='9') {
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
        }  //读取数字字符
        return res;
    }

    public static void main(String[] args) {
        String s = "-647555";
        int result = myAtoi(s);
        System.out.println("result = " + result);
    }
}
