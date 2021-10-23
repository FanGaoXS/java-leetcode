package subject25;

import datastruct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/19/18:13
 * @Description:
 */
class Solution {

    public static ListNode reverseKGroup1(ListNode head, int k) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (head!=null) {
            ArrayList<ListNode> nodes = new ArrayList<>();
            boolean flag = true;
            for (int i = 0; i < k; i++) {
                if (head == null) {
                    flag = false;
                    break;
                }
                nodes.add(head);
                head = head.next;
            }
            if (flag) {
                for (int i = k-1; i >= 0; i--) {
                    listNodes.add(nodes.get(i));
                }
            } else {
                listNodes.addAll(nodes);
            }
        }
        ListNode newHead = listNodes.get(0);
        for (int i = 1; i < listNodes.size(); i++) {
            newHead.next = listNodes.get(i);
            newHead = newHead.next;
        }
        newHead.next = null;
        return listNodes.get(0);
    }

    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode listNode = new ListNode(-1);
        ListNode tempNode = listNode;
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head!=null) {
            for (int i = 0; i < k; i++) {
                if (head == null) break;
                nodes.add(head);
                head = head.next;
            }
            if (nodes.size() == k) {//正好一组
                for (int i = k-1; i >= 0 ; i--) {
                    listNode.next = nodes.get(i);
                    listNode = listNode.next;
                }
            } else {    //不满足一组
                for (int i = 0; i < nodes.size(); i++) {
                    listNode.next = nodes.get(i);
                    listNode = listNode.next;
                }
            }
            nodes.clear();
        }
        listNode.next = null;
        return tempNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6))))));
        ListNode node = reverseKGroup1(head, 2);
        while (node!=null) {
            System.out.println("node.val = " + node.val);
            node = node.next;
        }
    }
}
