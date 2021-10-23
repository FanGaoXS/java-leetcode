package cn.fangaoxs.day32.subject704;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/19/21:51
 * @Description:        704. 二分查找
 *                      https://leetcode-cn.com/problems/binary-search/
 */
class Solution {
    public int search2(int[] nums, int target) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            integers.add(nums[i]);
        }
        return integers.indexOf(target);
    }
    public static int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;               //左
        int right = length-1;       //右
        while (left <= right) {
            int mid = (right - left)/2 + left;
            int num = nums[mid];
            if (target == num) {
                return mid;
            } else if (target > num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={-1,2,4};
        int target = -1;
        int i = search(nums, target);
        System.out.println("i = " + i);
    }
}
