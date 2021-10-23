package cn.fangaoxs.day8.subject215;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/26/21:49
 * @Description:
 */
public class Solution {

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int result = findKthLargest(nums, k);
        System.out.println("result = " + result);
    }

}
