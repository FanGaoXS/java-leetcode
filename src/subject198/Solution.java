package cn.fangaoxs.day27.subject198;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/14/22:07
 * @Description:    https://leetcode-cn.com/problems/house-robber/
 */
public class Solution {
    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        int[] money = new int[length];
        money[0] = nums[0];
        money[1] = Math.max(money[0],nums[1]);
        for (int i = 2; i < length; i++) {
            money[i] = Math.max(money[i-1],nums[i]+money[i-2]);
        }
        return money[length-1];
    }

    public static void main(String[] args) {
        //int[] nums = {1,2,3,1};
        int[] nums = {2,7,9,3,1};
        int rob = rob(nums);
        System.out.println("rob = " + rob);
    }
}
