package subject46;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/29/23:32
 * @Description:        https://leetcode-cn.com/problems/permutations/
 *                          1、每个位置按顺序枚举可能出现的情况
 *                          2、枚举的时候注意如果已经出现过则不能再添加
 */

public class Solution {

    private List<List<Integer>> lists;

    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.lists = new ArrayList<>();
        this.nums = nums;
        ArrayList<Integer> integers = new ArrayList<>();
        dfs(integers);
        return lists;
    }

    private void dfs(List<Integer> integers){
        if (integers.size() == nums.length) {
            lists.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //如果此组合已经包含此数字则return
            if (integers.contains(nums[i])) continue;
            //否则添加该数字
            integers.add(nums[i]);
            dfs(integers);
            integers.remove(integers.size()-1);
        }
    }

}
