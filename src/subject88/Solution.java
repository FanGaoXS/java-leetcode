package cn.fangaoxs.day4.subject88;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/22/14:21
 * @Description:
 */
class Solution {

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {2,5,6};
        int n = nums2.length;
        int m = nums1.length-n;
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("m = " + m);
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("n = " + n);
        merge(nums1, m, nums2, n);
        System.out.println("merged nums1 = " + Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) { //先合并两个数组
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1); //再排序

        /*for (int i = 0; i < m+n-1; i++) {
            for (int j = 0; j < m+n-1-i; j++) {
                if (nums1[j]>nums1[j+1]){
                    int temp = nums1[j+1];
                    nums1[j+1] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }*/
    }
}
