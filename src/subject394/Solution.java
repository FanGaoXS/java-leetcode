package cn.fangaoxs.day30.subject394;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/18/11:01
 * @Description:
 */
public class Solution {
    public String decodeString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder intSb = new StringBuilder();
                while (i<s.length()&&Character.isDigit(s.charAt(i))){
                    intSb.append(s.charAt(i));
                    i++;
                }
                int parseInt = Integer.parseInt(intSb.toString());
                if (s.charAt(i) == '[') {
                    int i1 = s.lastIndexOf(']');
                }
            }
        }
        return stringBuilder.toString();
    }
}
