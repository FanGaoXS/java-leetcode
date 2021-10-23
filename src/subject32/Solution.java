package cn.fangaoxs.day19.subject32;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/07/11:32
 * @Description:
 */
class Solution {
    public static int longestValidParentheses(String s) {
        int maxLength = 0;
        while (true){
            if (s.contains("()")){
                String replace = s.replace("()", "0");
                System.out.println("replace = " + replace);
                int sum = 0;
                for (int i = 0; i < replace.length(); i++) {
                    if (replace.charAt(i) == '0') {
                        sum+=2;
                    } else {
                        maxLength = Math.max(sum,maxLength);
                        sum = 0;
                    }
                }
                s = replace.replace("0", "");
            } else {
                break;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = ")((())";
        int i = longestValidParentheses(s);
        System.out.println("i = " + i);
    }
}
