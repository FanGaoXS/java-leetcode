package subject129;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/02/20:12
 * @Description:
 */
public class Solution {

    //深度优先遍历dfs
    public int sumNumbers(TreeNode root) {
        //每组深度上的各个数字
        ArrayList<Integer> integers = new ArrayList<>();
        //每组深度的和的集合
        ArrayList<Integer> sums = new ArrayList<>();
        int sum = 0;
        dfs(root,integers,sum,sums);
        for (Integer integer : sums) {
            sum += integer;
        }
        return sum;
    }

    private void dfs(TreeNode node, List<Integer> integers,int sum, List<Integer> sums){
        //node一定不为null
        integers.add(node.val);
        if (node.left==null&&node.right==null) {    //到达叶子节点
//            System.out.println("integers = " + integers);
            int size = integers.size();
            for (int i = 0; i < size; i++) {        //迭代integers中的数字，然后利用10的次方计算
//                System.out.println("Math.pow(i,10) * integers.get(i) = " + Math.pow(10, size-1-i) * integers.get(i));
                sum += Math.pow(10, size-1-i) * integers.get(i);
            }
            sums.add(sum);
//            System.out.println("sum = " + sum);
        }
        if (node.left!=null){
            dfs(node.left, integers, sum, sums);       //继续遍历左子树
        }
        if (node.right!=null){
            dfs(node.right, integers, sum, sums);      //继续遍历右子树
        }
        integers.remove(integers.size()-1);
    }
}
