package subject142;

import datastruct.ListNode;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/27/13:14
 * @Description:
 */
public class Solution2 {
    //set
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) return head;
            head = head.next;
        }
        return null;
    }
}
