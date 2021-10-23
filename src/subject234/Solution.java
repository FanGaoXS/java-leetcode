package subject234;

import datastruct.ListNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/17/10:05
 * @Description:
 */
class Solution {

    public static boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head!=null) {
            nodes.add(head);
            head = head.next;
        }   //list装链表中所有节点
        int size = nodes.size();
        for (int i = 0; i < size / 2; i++) {    //双指针往中间靠拢
            if (nodes.get(i).val!=nodes.get(size-1-i).val) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
