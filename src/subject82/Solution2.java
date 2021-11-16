package subject82;

import datastruct.ListNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/11/12/22:38
 * @Description:
 */
public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode resultNode = new ListNode(Integer.MIN_VALUE);
        ListNode tempNode = resultNode;
        while (head != null){
            //检查当前节点值和下一节点值是否相同
            if (head.next != null && head.val == head.next.val) {
                //迭代完当前节点值与下一节点值相同的节点
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                //迭代完后仍然需要再迭代一次（一组相同节点的最后一个）
                head = head.next;
                continue; //判断是否存在下一组相同的节点
            }
            resultNode.next = head;
            resultNode = resultNode.next;
            head = head.next;
        }
        return tempNode.next;
    }
}
