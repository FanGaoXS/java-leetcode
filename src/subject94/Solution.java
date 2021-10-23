package subject94;


import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/31/17:40
 * @Description:
 */
public class Solution {

    public static List<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        dfs(root,integers);
        return integers;
    }

    private static void dfs(TreeNode node, List<Integer> integers){
        if (node==null) return;
        dfs(node.left, integers);   //左子树继续执行dfs
        integers.add(node.val);
        dfs(node.right, integers);  //右子树继续执行dfs
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        List<Integer> integers = inorderTraversal1(root);
        System.out.println("integers = " + integers);
    }
}

