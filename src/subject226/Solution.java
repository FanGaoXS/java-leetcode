package subject226;

import datastruct.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/16/0:08
 * @Description:    226. 翻转二叉树
 *                  https://leetcode-cn.com/problems/invert-binary-tree/
 */
class Solution {

    public TreeNode invertTree(TreeNode root) {
        TreeNode tempRoot = root;
        dfs(root);
        return tempRoot;
    }

    private void dfs(TreeNode root){
        if (root == null) return;
        //交换左右子树----start
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        //交换左右子树----end
        dfs(root.left);
        dfs(root.right);
    }

    /*public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
    }*/

}
