package cn.fangaoxs.day11.subject41;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/30/0:05
 * @Description:
 */
public class Solution {
    public static int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(i,nums[i]);
        }
        for (int i = 1; i <=nums.length+1; i++) {
            if (!map.containsValue(i)) return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        int result = firstMissingPositive(nums);
        System.out.println("result = " + result);
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("(2>>31-1) = " + ((1<<31)-1)); //
    }
}
