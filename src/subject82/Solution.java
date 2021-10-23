package subject82;

import datastruct.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/09/20:28
 * @Description:    82. 删除排序链表中的重复元素 II
 *                  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null) return null;
        ListNode resultNode = new ListNode(Integer.MIN_VALUE);  //新链表（头节点）
        ListNode tempNode = resultNode;
        while (head!=null){ //迭代head链表
            if (head.next!=null && head.val == head.next.val) { //如果当前节点的值与下一节点的值相同了
                while (head.next!=null && head.val == head.next.val) {  //进入while循环，将所有相同元素迭代完毕
                    head = head.next;
                }
                head = head.next;   //最后还会有一组相同元素最后遗留的一个元素，仍然把他迭代掉
                continue;   //此时所有相同元素迭代完毕
            }
            resultNode.next = head;     //将此时的元素加入到新链表中

            resultNode = resultNode.next;   //新链表迭代
            head = head.next;               //head链表迭代
        }
        resultNode.next = null;             //最后需要注意将新链表的最后一个元素的next置为null
        return tempNode.next;
    }

    public static void main(String[] args) {
        //ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4,new ListNode(5)))))));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2)));
        ListNode node = deleteDuplicates(head);
        while (node!=null) {
            System.out.println("node.val = " + node.val);
            node = node .next;
        }
    }
}
