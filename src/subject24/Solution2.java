package subject24;

import datastruct.ListNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/11/05/18:02
 * @Description:
 */
public class Solution2 {
    //ArrayList迭代
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode resultNode = new ListNode(-1);
        ListNode tempNode = resultNode;
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int size = nodes.size();
        if (nodes.size()%2 != 0) {
            //如果链表中节点个数是奇数，则最后一个不需要交换
            size = nodes.size()-1;
        }
        for (int i = 0; i < size; i++) {
            if (i%2==0) {
                resultNode.next = nodes.get(i+1);
            } else {
                resultNode.next = nodes.get(i-1);
            }
            resultNode = resultNode.next;
        }
        if (nodes.size()%2 != 0) {
            resultNode.next = nodes.get(nodes.size()-1);
            resultNode = resultNode.next;
        }
        resultNode.next = null;
        return tempNode.next;
    }
}
