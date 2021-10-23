package subject543;

import datastruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/18/22:53
 * @Description:        543. 二叉树的直径
 *                      https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *                      Tips：二叉树的直径实际上就是某一结点的左子树到该结点和右子树到该结点的最大深度和
 *                      1、先求左右子树的最大深度：  https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *                      2、遍历二叉树的所有结点，求出当前遍历的结点的左右子树的最大深度和
 *                      3、其中直径即是遍历的所有结点的左右子树的最大深度和的最大值
 */
public class Solution {

    private static int diameter;

    private static Map<TreeNode,Integer> map = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {
        preorder(root);
        return diameter;
    }

    /**
     * 采用前序遍历访问所有root结点，以得出当前结点的左右子树的到该结点的最大深度和
     * @param root
     */
    private static void preorder(TreeNode root){
        if (root == null) return;
        int leftDepth = depth(root.left);   //左子树的最大深度
        int rightDepth = depth(root.right); //右子树的最大深度
        int path = leftDepth + rightDepth;  //当前结点的左子树的最大深度和右子树的最大深度和（即当前结点的最大路径长度）
        diameter = Math.max(path,diameter);
        depth(root);                //前序遍历
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 当前结点的最大深度（采用map作memory缓存，即之前求过某结点的最大深度下次再遍历的时候直接从map中取）
     * @param root  当前结点
     * @return      最大深度
     */
    public static int depth(TreeNode root){
        if (root == null) return 0; //叶子结点则返回0（没有深度）
        if (map.containsKey(root)) return map.get(root);    //如果之前访问过则直接从map中取
        int depth = Math.max(depth(root.left), depth(root.right)) + 1;  //当前结点的最大深度实质上就是左右子树分别深度的最大值+1
        map.put(root,depth);
        return depth;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3));
        int maxDepth = depth(root);
        System.out.println("maxDepth = " + maxDepth);
        preorder(root);
    }
}
