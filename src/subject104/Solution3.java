package subject104;

import datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/11/16/16:23
 * @Description:
 */
public class Solution3 {
    private int result;
    private int depth;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        result = Integer.MIN_VALUE;
        depth = 1;
        dfs(root);
        return result;
    }
    private void dfs(TreeNode root){
        if (root.left == null && root.right == null) {
            result = Math.max(depth,result);
            return;
        }
        depth ++;
        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
        depth --; //状态恢复
    }
}
