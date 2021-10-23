package subject1;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/20/17:40
 * @Description:
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println("i = " + i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (target - nums[i] == nums[j]) return new int[]{i,j};
            }
        }
        return new int[0];

    }
}
