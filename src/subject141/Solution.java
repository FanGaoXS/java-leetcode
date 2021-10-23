package subject141;

import datastruct.ListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/24/17:02
 * @Description:
 */

public class Solution {
    public static boolean hasCycle(ListNode head) {
        /**
         * set中如果已经存在该元素再次执行add添加的时候会失败
         */
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            boolean addResult = set.add(head);  //向set中添加元素（的地址）
            if (!addResult) return true;        //如果添加失败则说明已经存在该元素（已经被访问过）
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;           //慢指针
        ListNode fast = head.next;      //快指针
        while (fast!=null && fast.next!=null){
            if (slow == fast) return true;  //快慢指针相遇了
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        /*boolean result = hasCycle(head);

        System.out.println("result = " + result);*/

        int test = 5;

        HashSet<Integer> set = new HashSet<>();

        System.out.println("set.add(test) = " + set.add(test));
        System.out.println("set.add(test) = " + set.add(test));

    }
}

