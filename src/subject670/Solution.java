package cn.fangaoxs.day32.subject670;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/19/23:48
 * @Description:
 */
class Solution {
    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(-1,'9');
        for (int i = 0; i < numStr.length(); i++) {
            map.put(i,numStr.charAt(i));
        }   //迭代数值字符串，放置进map中
        int lowIndex = 0;
        int highIndex = 0;
        boolean flag = false;
        for (int i = 0; i < numStr.length(); i++) {
            if (map.get(i) < map.get(i-1)) {
                int maxNumber = map.get(i);
                lowIndex = i;
                for (int j = numStr.length()-1; j > i; j--) {
                    if (map.get(j) > maxNumber) {
                        maxNumber = map.get(j);
                        highIndex = j;
                        flag = true;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        if (highIndex>lowIndex) {
            return swap(map,lowIndex,highIndex);
        } else {
            return num;
        }
    }

    //交换两个数值字符串中两个下标的位置
    private int swap(Map<Integer,Character> numMap , int lowIndex, int highIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numMap.size()-1; i++) {
            if (i == lowIndex) {
                sb.append(numMap.get(highIndex));
                continue;
            } else if (i == highIndex) {
                sb.append(numMap.get(lowIndex));
                continue;
            }
            sb.append(numMap.get(i));
        }
        return Integer.parseInt(sb.toString());
    }
}
