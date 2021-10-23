package subject83;

import datastruct.ListNode;

import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/09/19:42
 * @Description:
 *                  83. 删除排序链表中的重复元素
 *                  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        TreeSet<Integer> set = new TreeSet<Integer>();
        while (head!=null) {
            set.add(head.val);
            head = head.next;
        }
        ListNode resultNode = new ListNode(-1);
        ListNode tempResultNode = resultNode;
        for (Integer integer : set) {
            resultNode.next = new ListNode(integer);
            resultNode = resultNode.next;
        }
        return tempResultNode.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode tempHead = head;
        while (head!=null){
            //在下一个节点存在的前提下（可能为null）
            if (head.next!=null && head.val == head.next.val){
                //当前节点与下一节点元素相同
                //移除下一节点
                head.next = head.next.next;
                continue;   //继续与下一节点比较
            }
            head = head.next;
        }
        return tempHead;
    }

    public static void main(String[] args) {
        //ListNode head = new ListNode(-3, new ListNode(-1, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(3, new ListNode(3)))))));
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode node = deleteDuplicates2(head);
        while (node!=null) {
            System.out.println("node.val = " + node.val);
            node = node.next;
        }
    }

}
