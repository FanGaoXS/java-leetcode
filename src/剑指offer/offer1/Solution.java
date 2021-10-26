package 剑指offer.offer1;

import datastruct.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/10/26/17:46
 * @Description:
 */

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> integers = new ArrayList<>();
        while (listNode != null) {
            integers.add(listNode.val);
            listNode = listNode.next;
        }
        
        Collections.reverse(integers);
        return integers;
    }
}
