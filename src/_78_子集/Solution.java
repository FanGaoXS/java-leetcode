package cn.fangaoxs.day21._78_子集;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/08/16:07
 * @Description:
 *                      https://leetcode-cn.com/problems/subsets/
 */
class Solution {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());       //首个集合加入空集
        for (int i = 0; i < nums.length; i++) { //迭代数组中的元素
            int size = lists.size();
            for (int j = 0; j < size; j++) {
                //迭代当前结果集中元素创建新的集合
                ArrayList<Integer> integers = new ArrayList<>(lists.get(j));
                //往新的集合中加入当前位置的数组元素
                integers.add(nums[i]);
                //最后加入结果集中
                lists.add(integers);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = subsets(nums);
        System.out.println("lists = " + lists);
    }
}
