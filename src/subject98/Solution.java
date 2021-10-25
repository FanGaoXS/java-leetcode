package subject98;

import datastruct.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/25/16:44
 * @Description:
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root,long lower,long upper){
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBST(root.left,lower, root.val) && isValidBST(root.right, root.val, upper);
    }
}
