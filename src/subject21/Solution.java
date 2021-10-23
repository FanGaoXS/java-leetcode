package cn.fangaoxs.day3.subject21;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/21/20:36
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = mergeTwoLists(l1, l2);
        while (result!=null){
            System.out.println("result.val = " + result.val);
            result = result.next;
        }

    }

    /**
     *
     * @param l1          递增序列
     * @param l2          递增序列
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode();
        ListNode resultNode = newNode; //先将新链表的头存储起来
        while (l1!=null||l2!=null){
            if (l2==null){             //如果l2已经迭代到null，则直接将l1插入到链表上
                newNode.next = l1;
                break;
            } else if (l1==null){
                newNode.next = l2;
                break;
            } else if (l1.val < l2.val){    //如果l1的值小于l2，则插入l1，l1迭代
                newNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1.val >= l2.val){
                newNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            newNode = newNode.next;
        }

        return resultNode.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
