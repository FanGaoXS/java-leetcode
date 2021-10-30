package subject19;

import datastruct.ListNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/30/14:58
 * @Description:
 */
public class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode resultNode = new ListNode(-1, head);
        ArrayList<ListNode> nodes = new ArrayList<>();
        nodes.add(resultNode);
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int size = nodes.size();
        if (n == 1) {
            nodes.get(size-1-n).next = null;
        } else {
            nodes.get(size-1-n).next = nodes.get(size+1-n);
        }
        return resultNode.next;
    }
}
