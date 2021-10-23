package subject24;

import datastruct.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/06/17:32
 * @Description:
 */
class Solution {
    public static ListNode swapPairs(ListNode head) {
        //没有或者只有一个节点
        if (head==null||head.next==null) return head;
        ListNode first = new ListNode(-1,head);     //插入一个头节点，方便交互第一个节点
        ListNode preNode = first;
        while (head!=null){     //两两一组进行
            if (head.next==null) break;             //偶数位为null，说明最后一个位置的第二个节点为null，不需要交换
            ListNode firstNode = head;              //第一个节点
            ListNode secondNode = head.next;        //第二个节点
            firstNode.next = secondNode.next;       //将第二个节点的next（第三个节点）赋值给第一个节点的next
            secondNode.next = firstNode;            //将第一个节点赋值给第二个节点的next（此时两节点完成交换）
            preNode.next = secondNode;              //把目前第一个节点（刚才的第二个节点）赋值给该组节点的前置节点
            head = head.next;                       //head迭代
            preNode = firstNode;                    //将目前的第二个节点（刚才的第一个节点）暂存为前置节点（供下一组使用）
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4/*, new ListNode(5)*/))));
        ListNode result = swapPairs(head);
        while (result!=null){
            System.out.println("result.val = " + result.val);
            result = result.next;
        }
    }
}
