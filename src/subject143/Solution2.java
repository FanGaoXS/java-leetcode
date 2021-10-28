package subject143;

import datastruct.ListNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/28/15:24
 * @Description:
 */
public class Solution2 {
    public void reorderList(ListNode head) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        boolean flag = true;
        ListNode tempNode = nodes.get(0);
        int l = 1;
        int r = nodes.size()-1;
        for (int i = 1; i < nodes.size(); i++) {
            if (flag) {
                tempNode.next = nodes.get(r);
                r--;
            } else {
                tempNode.next = nodes.get(l);
                l++;
            }
            flag = !flag;
            tempNode = tempNode.next;
        }
        tempNode.next = null;
        head = nodes.get(0);
    }
}
