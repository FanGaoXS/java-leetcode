package subject102;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/23/17:37
 * @Description:
 */
class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2,new TreeNode(4),null);
        root.right = new TreeNode(3,null,new TreeNode(5));
        List<List<Integer>> lists = levelOrder(root);
        System.out.println("lists = " + lists);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);              //头节点入队
        while (!queue.isEmpty()){       //队列中存在元素则迭代
            int size = queue.size();    //该size是每层的节点数
            ArrayList<Integer> integers = new ArrayList<>(size);
            for (int i = 0; i < size; i++) { //迭代该层的每一节点
                TreeNode node = queue.poll();       //出队列
                integers.add(node.val);             //把出队列的节点值添加
                if (node.left!=null){
                    queue.offer(node.left);         //左子节点入队
                }
                if (node.right!=null){
                    queue.offer(node.right);        //右子节点入队
                }
            }
            lists.add(integers);
        }
        return lists;
    }
}


