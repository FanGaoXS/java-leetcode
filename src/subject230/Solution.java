package subject230;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/16/0:24
 * @Description:    230. 二叉搜索树中第K小的元素
 *                  https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
class Solution {

    public int kthSmallest2(TreeNode root, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        dfs2(root,integers);
        return integers.get(k-1);
    }
    private void dfs2(TreeNode node, List<Integer> integers){
        if (node == null) return;
        dfs2(node.left,integers);
        integers.add(node.val); //中序遍历
        dfs2(node.right,integers);
    }

    private int k;

    private int n;

    private int result;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.n = 0;
        dfs(root);
        return result;
    }

    //中序遍历
    private void dfs(TreeNode node){
        if (node.left!=null) {
            dfs(node.left);
        }
        n++;
        if (n == k) {
            result = node.val;  //如果n等于k了则返回结果
        } else if (n > k) {       //剪枝
            return;
        }
        if (node.right!=null) {
            dfs(node.right);
        }
        if (node.left == null&&node.right == null) { //叶子节点
            return;
        }
    }
}
