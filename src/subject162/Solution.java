package cn.fangaoxs.day26.subject162;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/14/0:14
 * @Description:        162. 寻找峰值
 *                      https://leetcode-cn.com/problems/find-peak-element/
 */
public class Solution {

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0; //如果只有一个数字，则它本身就是峰值
        int max = Integer.MIN_VALUE;
        int result = 0;
        //峰值出现的规律总是在出现较大值后一个元素一定得小于该数
        for (int i = 0; i < nums.length; i++) {//迭代数组，依次取得目前的较大值
            if (nums[i]>max) {
                max = nums[i];  //当前迭代到此时的最大值
                if (i==nums.length-1||nums[i]>nums[i+1]) {
                    //如果下一个元素小于该当前最大值，那么则这个最大值就是峰值
                    //如果已经迭代到了最后一个元素（并且该元素是最大值，由于nums[n]一定比他小），所以它也是峰值（最后一个元素）
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {7,5,3,1};
        int[] nums = {-2147483648};
        int peak = findPeakElement(nums);
        System.out.println("peak = " + peak);
    }
}
