package subject110;

import datastruct.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/11/12:31
 * @Description:
 */
public class Solution {
    /*public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

    }*/

    private static int height(TreeNode node){
        if (node == null) return 0;
        int maxHeight = 0;
        dfs(node,1,maxHeight);
        return maxHeight;
    }

    private static void dfs(TreeNode node,int height,int maxHeight){
        if (node.left == null&&node.right == null) {
            maxHeight = Math.max(maxHeight,height);
            return ;
        }
        height++;
        if (node.left != null) {
            dfs(node.left,height,maxHeight);
        }
        if (node.right != null) {
            dfs(node.right,height,maxHeight);
        }
        height--;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int height = height(root);
        System.out.println("height = " + height);
    }

}
