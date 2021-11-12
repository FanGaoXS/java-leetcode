package _78_子集;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/11/11/20:24
 * @Description:
 */
public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = lists.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> integers = new ArrayList<>(lists.get(j));
                integers.add(nums[i]);
                lists.add(integers);
            }
        }
        System.out.println("lists = " + lists);
        return lists;
    }
}
