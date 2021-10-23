package cn.fangaoxs.day18.subject4;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/06/11:07
 * @Description:
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            if (i >= m) {
                nums[i] = nums2[i-m];
                continue;
            }
            nums[i] = nums1[i];
        }   //数组合并
        Arrays.sort(nums);  //数组排序
//        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
        if (length%2 == 0) {    //偶数
            int num1 = nums[length / 2 - 1];
            int num2 = nums[length / 2];
//            System.out.println("(num1 + num2)/2 = " + (double) (num1 + num2) / 2);
            return (double) (num1 + num2) / 2;
        } else {    //奇数
//            System.out.println("nums[length/2] = " + nums[length / 2]);
            return nums[length / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1};
        findMedianSortedArrays(nums1,nums2);
    }
}
