package subject236;

import datastruct.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/26/22:41
 * @Description:
 */
public class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer, TreeNode> parentMap = new HashMap<>();     //所有子节点的父节点（key=子节点值，value=父节点）
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                    //把该节点作为以（左节点值，当前节点）存入map（左节点是子节点，当前节点是它的父节点）
                    parentMap.put(node.left.val,node);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                    parentMap.put(node.right.val,node);
                }
            }
        }
        HashSet<TreeNode> visitedSet = new HashSet<>();        //访问过的节点set
        while (p!=null){
            visitedSet.add(p);
            p = parentMap.get(p.val); //根据p的值获取p的父节点
        }
        while (q!=null){
            if (!visitedSet.add(q)) return q;   //如果set中添加失败，说明该父节点被访问过，则是公共祖先节点
            q = parentMap.get(q.val);   //根据q的值获取q的父节点
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root
                = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.println("node.val = " + node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
    }
}

