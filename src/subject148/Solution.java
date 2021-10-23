package subject148;

import datastruct.ListNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/12/14:53
 * @Description:
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head!=null) {
            nodes.add(head);
            head = head.next;
        } //nodes迭代完毕
        for (int i = 0; i < nodes.size()-1; i++) {
            for (int j = 0; j < nodes.size()-1-i; j++) {
                if (nodes.get(j).val>nodes.get(j+1).val) {
                    ListNode temp = nodes.get(j);
                    nodes.set(j,nodes.get(j+1));
                    nodes.set(j+1,temp);
                }
            }
        }
        ListNode resultNode = new ListNode(-1);
        ListNode tempNode = resultNode;
        for (int i = 0; i < nodes.size(); i++) {
            resultNode.next = nodes.get(i);
            resultNode = resultNode.next;
        }
        resultNode.next = null;
        return tempNode.next;
    }
}
