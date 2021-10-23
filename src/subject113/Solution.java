package subject113;

import datastruct.TreeNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/01/21:00
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("(int) Character.MIN_VALUE = " + (int) Character.MIN_VALUE);
        System.out.println("(int)Character.MAX_VALUE = " + (int) Character.MAX_VALUE);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        int sum = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        dfs(root,targetSum,sum,integers,lists);
        return lists;
    }

    private static void dfs(TreeNode node,
                            int targetSum,
                            int sum,
                            List<Integer> integers,
                            List<List<Integer>> lists){
        //进入dfs的node一定不为null
//        System.out.println("node.val = " + node.val);
        sum += node.val;
        integers.add(node.val);
        if (node.left==null&&node.right==null){ //左右子树为null，说明已经达到叶子节点
            if (sum==targetSum) {
//                System.out.println("sum = " + sum);
//                System.out.println("integers = " + integers);
                lists.add(integers);
            }
        }
        if (node.left!=null){   //遍历左子树
            dfs(node.left,targetSum,sum,integers,lists);
        }
        if (node.right!=null){  //遍历右子树
            dfs(node.right,targetSum,sum,integers,lists);
        }
        //当前节点的左右子树遍历完毕后移除当前节点值（退回上一节点）
        integers.remove(integers.size()-1);
    }
}
