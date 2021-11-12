package subject83;

import datastruct.ListNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/11/12/22:39
 * @Description:
 */
public class Solution3 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ArrayList<Integer> integers = new ArrayList<>();
        //将链表头节点加入list
        integers.add(head.val);
        head = head.next;
        while (head != null) {
            //如果当前节点的值不等于list最后一个元素的值，说明当前节点与list集合中最后一个元素不重复
            if (head.val != integers.get(integers.size()-1)){
                //将当前节点值加入list中
                integers.add(head.val);
            }
            head = head.next;
        }
        //重新将list中值组成新链表
        ListNode resultNode = new ListNode(-1);
        ListNode tempNode = resultNode;
        for (int i = 0; i < integers.size(); i++) {
            resultNode.next = new ListNode(integers.get(i));
            resultNode = resultNode.next;
        }
        return tempNode.next;
    }
}
