package subject2;

import datastruct.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/28/19:52
 * @Description:
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean add = false;                //指定一个标识位判断下一位是否需要进1
        ListNode node = new ListNode();
        ListNode resultNode = node;
        while (add||l1!=null||l2!=null){
            int sum = 0;
            if (add) {
                sum+=1;
                add = false;
            }
            if (l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(sum%10);
            node = node.next;
            if (sum>=10){
                add = true;
            }
        }
        return resultNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(8)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode node = addTwoNumbers(l1, l2);
        while (node!=null){
            System.out.println("node.val = " + node.val);
            node = node.next;
        }
    }
}

