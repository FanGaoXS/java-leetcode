package subject958;

import datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/05/0:56
 * @Description:
 */
public class Solution {
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isSecondToLastComplete = true;
        while (!queue.isEmpty()){
            //每层
            int size = queue.size();
            boolean[] booleans = new boolean[size * 2]; //定义一个布尔数组来记录元素的位置
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                    booleans[i*2] = true;
                }
                if (node.right!=null){
                    queue.offer(node.right);
                    booleans[i*2+1] = true;
                }
            }
            if (!isSecondToLastComplete){
                //如果刚刚“最后”一层暂时满足条件了，但是它的下一层还有元素，说明错误
                return queue.size() == 0;   //如果没有元素则是正确的，否则错误
            }
            // 如果最后一层的元素数量不等于上一层元素数量的2倍
            if (queue.size()!=size*2){   //如果当前队列大小不为之前队列大小的2倍（说明最后一层不满）
                for (int i = 0; i < booleans.length; i++) {
                    if (i!=booleans.length-1){
                        if (!booleans[i]&&booleans[i+1]){
                            //判断布尔数组：
                            //如果类似如下则返回说明不是元素靠左：
                            // true false true true
                            return false;
                        }
                    }
                }//代码执行到此，说明“最后”一层元素是不满的，但是确实全部靠左的
                isSecondToLastComplete = false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        boolean result = isCompleteTree(root);
        System.out.println("result = " + result);
    }
}
