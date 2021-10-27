package subject129;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/27/13:32
 * @Description:
 */
public class Solution2 {
    private int sum = 0;
    private List<Integer> nums = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        dfs(root);
        return sum;
    }
    private void dfs(TreeNode root){
        nums.add(root.val);
        //到达叶子节点
        if (root.left == null && root.right == null) {
            /*
                如[4,9,1]
                = 4*10^2 + 9*10^1 + 1*10^0 = 491
                即nums[i]*10^(nums.length-1-i)
             */
            for (int i = 0; i < nums.size(); i++) {
                //依次取出当前位置的数字
                int num = nums.get(i);
                sum += num * Math.pow(10, nums.size()-1-i);
            }
        }
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
        nums.remove(nums.size()-1);
    }
}
