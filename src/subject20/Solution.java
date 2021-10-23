package cn.fangaoxs.day1.subject20;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/19/18:36
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        String s = "[{)]";
        System.out.println("isValid(s) = " + isValid(s));
    }

    public static boolean isValid(String s) {
        while (true){
            if (s.contains("{}")){
                s = s.replace("{}","");
            } else if (s.contains("()")) {
                s = s.replace("()", "");
            } else if (s.contains("[]")) {
                s = s.replace("[]", "");
            } else {
                break;
            }
        }
        return s.equals("");
    }
}
