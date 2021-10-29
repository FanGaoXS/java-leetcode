package 剑指offer.offer22;

import datastruct.ListNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/29/17:00
 * @Description:
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        return nodes.get(nodes.size()-k);
    }

    public static void main(String[] args) {
        int x=0;
        int y=11;
        do {} while (x++<y);
        System.out.println("x = " + x);
    }
}
