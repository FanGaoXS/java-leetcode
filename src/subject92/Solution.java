package subject92;

import datastruct.ListNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/01/11:00
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int left = 2;
        int right = 4;
//        ListNode result = reverseBetween1(root, left, right);
        /*ListNode result2 = reverseBetween2(root, left, right);
        while (result2!=null){
            System.out.println("result.val = " + result2.val);
            result2 = result2.next;
        }*/
    }

    /*public static ListNode reverseBetween1(ListNode head, int left, int right) {
        if(head.next==null) return head; //只有一个结点则直接返回
        ListNode root = new ListNode(-1, head);
        ListNode preLeftNode = root;
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = right;
        for (int i = 1; i <= right; i++) {
            root = root.next;
            if (i==left-1){ //left位置的前一个结点
                *//*System.out.println("i = " + i);
                System.out.println("root.val = " + root.val);*//*
                preLeftNode = root;
            }
            if (i>=left){
                map.put(j, root.val);
                System.out.println("j = " + j);
                System.out.println("root.val = " + root.val);
                j--;
            }
        }
        ListNode reverseNode = new ListNode(-1);
        ListNode reverseNodeTemp = reverseNode;
        for (int i = left ; i <= right ; i++) {
            reverseNode.next = new ListNode(map.get(i));
            reverseNode = reverseNode.next;
        }
        reverseNode.next = root.next;
        preLeftNode.next = reverseNodeTemp.next;
        System.out.println("root.val = " + root.val);
        System.out.println("preLeftNode.val = " + preLeftNode.val);
        return null;
    }*/

    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head.next==null) return head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int i = 1;
        int j = right;
        // 先迭代链表，到了需要反转的区间时后直接反向存入map
        while (head!=null){
            //如果i位于left到right的范围内，则map直接存反转后的val
            if (i>=left&&i<=right){
                map.put(j,head);
                j--;
            } else {
                //否则正常按照位置存入
                map.put(i,head);
            }
            i++;
            head = head.next;
        }
        ListNode node = new ListNode(-1);
        ListNode nodeTemp = node;
        // 迭代map给node赋值
        for (int k = 1; k <= map.size(); k++) {
            node.next = new ListNode(map.get(k).val);
            node = node.next;
        }
        return nodeTemp.next;
    }

}

