package cn.fangaoxs.day26.subject169;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/13/23:36
 * @Description:
 */
class Solution {
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        //数组一半长
        int halfLength = nums.length / 2;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            //迭代数组元素
            if (!map.containsKey(nums[i])){
                //如果map中不包括该数组元素，说明没有访问过，则该元素作为key，出现的次数作为value存入
                map.put(nums[i], 1);
            } else {
                //否则则说明map中包含该元素，即访问过，则该元素的value（出现的次数增加1次）
                Integer count = map.get(nums[i]);
                if ((count+1)>halfLength) {
                    //如果次数已经大于数组一半长了，则直接返回结果
                    result = nums[i];
                    break;
                }
                map.put(nums[i], count+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        int result = majorityElement(nums);
        System.out.println("result = " + result);
    }
}
