package cn.fangaoxs.day10.subject5;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/28/21:56
 * @Description:
 */
public class Solution {
    public static String longestPalindrome(String s) {
        int maxLength = 0;
        int begin = 0;
        int end = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-1; j > i ; j--) {
                int left = i;
                int right = j;
                while (s.charAt(left) == s.charAt(right)) {
                    if (left==right||left==right-1){
                        /*System.out.println("(j+1-i) = " + (j + 1 - i));
                        System.out.println("maxLength = " + maxLength);*/
                        if (j+1-i>maxLength) {
                            begin = i;
                            end = j+1;
                            maxLength = j+1-i;
                        }
                        /*System.out.println("begin = " + begin);
                        System.out.println("end = " + end);*/
                        break;
                    }
                    left++;
                    right--;
                }
            }
        }
        System.out.println("begin = " + begin);
        System.out.println("end = " + end);
        return s.substring(begin,end);
    }

    public static void compare(String s,int left,int right){
        if (s.charAt(left)==s.charAt(right)) {
            compare(s,left+1,right-1);
        }
    }

    public static void main(String[] args) {
        String s = "abdsadadsad23ewdasda";
        String longestPalindrome = longestPalindrome(s);
        System.out.println("longestPalindrome = " + longestPalindrome);
    }
}
