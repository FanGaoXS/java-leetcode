package subject113;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/26/14:47
 * @Description:
 */
public class Solution2 {
    private List<List<Integer>> list = new ArrayList<>();
    private List<Integer> integers = new ArrayList<>();
    private int sum = 0;
    private int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return list;
        this.targetSum = targetSum;
        dfs(root);
        return list;
    }
    private void dfs(TreeNode root) {
        sum += root.val;
        integers.add(root.val);
        //到达叶子节点了
        if (root.left == null&&root.right == null) {
            if (sum == targetSum) {
                /*System.out.println("sum = " + sum);
                System.out.println("integers = " + integers);*/
                list.add(new ArrayList<>(integers));
            }
        }
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
        sum-=root.val;
        integers.remove(integers.size()-1);
    }
}
