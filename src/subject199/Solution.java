package subject199;

import datastruct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/25/17:07
 * @Description:
 */
public class Solution {

    public static List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> integers = new LinkedList<>();
        if (root==null) return integers;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                if (i==size-1){
                    integers.add(node.val);
                }
            }
        }
        return integers;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2,null,new TreeNode(5));
        root.right = new TreeNode(3,null,new TreeNode(4));
        List<Integer> integers = rightSideView(root);
        integers.forEach(integer -> System.out.println("integer = " + integer));
    }

}

