package subject112;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/01/20:06
 * @Description:
 */
public class Solution {

    public static boolean hasPathSum(TreeNode root,int targetSum) {
        if (root==null) return false;
        int sum = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        dfs(root,sum,targetSum,integers);   //进入递归
        return !integers.isEmpty();
    }

    private static void dfs(TreeNode node, int sum, int targetSum, List<Integer> integers){
        sum += node.val;
        if (node.left==null&&node.right==null){ //到达叶子节点（无左右子树）
            //System.out.println("sum = " + sum);
            if (sum==targetSum) integers.add(sum); //如果和与目标和相等
        }
        if (node.left!=null){
            dfs(node.left,sum,targetSum,integers);
        }
        if (node.right!=null){
            dfs(node.right,sum,targetSum,integers);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        int targetSum = 6;
        boolean b = hasPathSum(root,targetSum);
        System.out.println("b = " + b);
    }
}
