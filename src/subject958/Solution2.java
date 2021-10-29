package subject958;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/29/15:04
 * @Description:
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] ints = new int[5];
        for (int i : ints) {
            System.out.println("i = " + i);
        }
    }
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        //层序优先遍历
        while (!queue.isEmpty()){
            //当前层的元素个数
            int size = queue.size();
            //下一层理想（满）的元素个数
            int nextIdealSize = (int) Math.pow(2, level);
            //下一次的元素数组的排列顺序
            boolean[] nextBools = new boolean[nextIdealSize];
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    //如果左子树有元素，对应的位置置为true
                    nextBools[i*2] = true;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    //如果右子树有元素，对应的位置置为true
                    nextBools[i*2+1] = true;
                }
            }
            //此时的队列的大小是下层的元素个数
            //如果下一层的元素不是理想个数（不满），则下层可能是最后一层
            if (queue.size()!=nextIdealSize) {
                //判断是否按照从左往右排序
                for (int i = 0; i < nextBools.length-1; i++) {
                    if (!nextBools[i]&&nextBools[i+1]){
                        return false;
                    }
                }
                //判断下层的元素是否还有子树，如果有，则不满足条件
                while (!queue.isEmpty()){
                    TreeNode poll = queue.poll();
                    if (poll.left!=null||poll.right!=null){
                        return false;
                    }
                }
            }
            level ++;
        }
        return true;
    }
}
