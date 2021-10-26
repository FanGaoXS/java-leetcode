package subject112;

import datastruct.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/26/14:39
 * @Description:
 */
public class Solution2 {
    private int targetSum;
    private int sum = 0;
    private boolean result = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        this.targetSum = targetSum;
        dfs(root);
        return result;
    }
    private void dfs(TreeNode root) {
        if (result) return;
        sum+=root.val;
        //没有左右子树了（到达叶子节点）
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                result = true;
            }
        }
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
        sum-=root.val;
    }
}
