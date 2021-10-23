package subject19;

import datastruct.ListNode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/05/18:46
 * @Description:
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode resultNode = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int i = 0;
        while (head!=null){
            map.put(i,head);
            head = head.next;
            i++;
        }
        int posSize = i-n+1;                  //被删除节点的后一节点的下标
        ListNode posNode = map.get(posSize);  //被删除节点的后一节点
        int preSize = i-n-1;                  //被删除节点的前一节点的下标
        if (preSize == -1) {//如果前一结点的下标是-1说明被删除的节点是头节点
            return map.get(1);  //直接返回第二个节点
        }
        ListNode preNode = map.get(preSize);  //被删除节点的前一节点
        preNode.next = posNode;
        return resultNode;
    }
}
