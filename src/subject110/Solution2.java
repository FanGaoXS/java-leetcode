package subject110;

import datastruct.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/11/16/16:47
 * @Description:
 */
public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return false;

    }

    //返回当前节点的高度
    private int height(TreeNode root) {
        //到达叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        if (root.left != null) {

        }
        if (root.right != null) {

        }
    }

}
