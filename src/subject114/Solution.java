package subject114;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/12/11:39
 * @Description:
 *                      114. 二叉树展开为链表
 *                      https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class Solution {



    public static void flatten(TreeNode root) {
        if (root == null) return;
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        preorderTraversal(root,nodeList);   //前序遍历root二叉树，并且依次添加进list中
        TreeNode tempRoot = root;
        //迭代list，左子树置为null
        for (int i = 1; i < nodeList.size(); i++) {
            root.left = null;
            root.right = new TreeNode(nodeList.get(i).val);
            root = root.right;
        }
        root = tempRoot;

    }

    public static void preorderTraversal(TreeNode node,List<TreeNode> nodeList) {
//        System.out.println("node.val = " + node.val);
        nodeList.add(node);
        if (node.left == null && node.right == null) return;
        if (node.left != null) preorderTraversal(node.left,nodeList);
        if (node.right != null) preorderTraversal(node.right,nodeList);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        flatten(root);
    }

}
