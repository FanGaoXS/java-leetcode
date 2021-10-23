package subject103;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/24/0:17
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9,null,null);
        root.right = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        List<List<Integer>> lists = zigzagLevelOrder(root);
        System.out.println("lists = " + lists);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;    //从左往右
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> integers = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    integers.add(node.val);           //顺序添加
                } else {
                    integers.add(0, node.val);  //倒序添加
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            flag = !flag; //flag取反
            lists.add(integers);
        }
        return lists;
    }

}
