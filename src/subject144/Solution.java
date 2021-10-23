package subject144;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/12/13:47
 * @Description:
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (root == null) return integers;
        dfs(root,integers);
        return integers;
    }
    private void dfs(TreeNode root,List<Integer> integers){
        if (root.left != null)  dfs(root.left, integers);
        if (root.right != null)  dfs(root.right, integers);
        integers.add(root.val);
        if (root.left == null&&root.right == null) return;
    }
}
