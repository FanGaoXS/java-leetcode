package offer22;

import datastruct.ListNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/05/0:43
 * @Description:
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null) return null;
        ArrayList<ListNode> list = new ArrayList<>();
        while (head!=null){
            list.add(head);
            head = head.next;
        }
        int size = list.size();
        return list.get(size-k);
    }
    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (head==null) return null;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int i = 0;
        while (head!=null){
            map.put(i,head);
            head = head.next;
            i++;
        }
        int size = map.size();
        return map.get(size-k);
    }
}
