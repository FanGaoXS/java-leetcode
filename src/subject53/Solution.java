package cn.fangaoxs.day4.subject53;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/22/16:36
 * @Description:
 */
class Solution {

    public static void main(String[] args) {
        int[] nums = {-1,-2};
        int result = maxSubArray(nums);
        System.out.println("result = " + result);
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0]; //如果数组长度为1
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]>0) { //如果前一个元素大于0则累加到当前元素上
                nums[i] += nums[i-1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            // 返回整个数组中的最大值
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
