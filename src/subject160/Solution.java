package subject160;

import datastruct.ListNode;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/25/17:07
 * @Description:
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if (!set.add(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}

