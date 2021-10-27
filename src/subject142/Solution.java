package subject142;

import datastruct.ListNode;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/02/19:57
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){ //迭代链表
            if (!set.add(head)) return head;    //如果向set中添加节点失败，说明这是第二次访问了（即重复）
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return slow;
        }
        return null;
    }

}
