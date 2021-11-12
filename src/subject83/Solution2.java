package subject83;

import datastruct.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/11/12/22:13
 * @Description:
 */
public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode tempNode = head;
        while (head != null) {
            //如果下一节点存在并且当前节点值和下一节点值相同
            //则当前节点指向下下一节点
            if (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
                continue; //当前节点继续与下一节点比较
            }
            head = head.next;
        }
        return tempNode;
    }
}
