package cn.fangaoxs.day2.subject15;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/23/21:10
 * @Description:        15. 三数之和
 *                      https://leetcode-cn.com/problems/3sum/
 */
public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) return lists;
        //数组排序
        Arrays.sort(nums);
        int n = nums.length;
        //迭代nums[i]
        for (int i = 0; i < n; i++) {
            //如果nums[i]已经大于0了，那么后面的nums[i]必不可能还有与它和为0的数
            if (nums[i] > 0) return lists;
            //遇到重复的直接跳过
            if (i > 0 && nums[i] == nums[i-1]) continue;
            //左右指针
            int left = i+1;
            int right = n-1;
            while (left < right) {
                int sum  = nums[i] + nums[left] + nums[right];
                if (sum > 0) { //如果和大于1，则右指针左移
                    //迭代完所有重复元素
                    while (left < right && nums[right] == nums[--right]);
                } else if (sum < 0) {   //如果和小于1，则左指针右移
                    while (left < right && nums[left] == nums[++left]);
                } else {    //和刚好等于1
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[left]);
                    integers.add(nums[right]);
                    lists.add(integers);
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println("lists = " + lists);
    }
}
