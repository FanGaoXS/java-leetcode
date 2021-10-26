package newcoder;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/25/18:06
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }
        ArrayList<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                int result = o2.getValue() - o1.getValue();
                if (result == 0) {
                    int i = (int)o1.getKey();
                    int j = (int)o2.getKey();
                    if (i>=65&&i<=90){
                        i += 58;
                    }
                    if (j>=65&&j<=90){
                        j += 58;
                    }
                    return i - j;
                } else {
                    return result;
                }
            }
        });
        list.forEach(item->{
            System.out.print(item.getKey()+":"+item.getValue()+";");
        });
        scanner.close();
    }
}
