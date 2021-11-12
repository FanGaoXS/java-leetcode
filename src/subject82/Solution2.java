package subject82;

import datastruct.ListNode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/11/12/22:38
 * @Description:
 */
public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head.next == null) return head;
        ArrayList<Integer> integers = new ArrayList<>();
        while (head != null){
            
            head = head.next;
        }
    }
}
