package cn.fangaoxs.day33.subject912;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/20/18:56
 * @Description:
 */
class Solution {
    public static int[] sortArray1(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    public static int[] sortArray(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                if (nums[j]>nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = false;
                }

            }
            if (flag) break;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        int[] sortArray = sortArray(nums);
        System.out.println("Arrays.toString(sortArray) = " + Arrays.toString(sortArray));
    }
}
