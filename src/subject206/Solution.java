package subject206;

import datastruct.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/08/26/17:21
 * @Description:
 */
public class Solution {

    //ArrayList，存储int类型
    public static ListNode reverseList1(ListNode head) {
        if (head==null) return null;
        ArrayList<Integer> integers = new ArrayList<>();
        while (head!=null){
            integers.add(head.val);
            head = head.next;
        }
        ListNode node = new ListNode();
        ListNode resultNode = node;
        for (int i = integers.size()-1; i >=0; i--) {
            node.next = new ListNode(integers.get(i));
            node = node.next;
        }
        return resultNode.next;
    }

    //ArrayList，存储ListNode类型
    public static ListNode reverseList2(ListNode head){
        if (head == null) return null;
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (head!=null){
            listNodes.add(head);
            head = head.next;
        }
        int size = listNodes.size();
        ListNode node = listNodes.get(size-1);
        ListNode tempNode = node;
        for (int i = listNodes.size()-2; i >= 0 ; i--) {
            node.next = listNodes.get(i);
            node = node.next;
        }
        node.next = null;
        return tempNode;
    }

    // map，map的value是int类型
    public static ListNode reverseList3(ListNode head){
        if (head == null) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (head!=null){
            map.put(i, head.val);
            head = head.next;
            i++;
        }
        ListNode node = new ListNode(-1);
        ListNode tempNode = node;
        int size = map.size();
        for (int j = size-1; j >= 0 ; j--) {
            node.next = new ListNode(map.get(j));
            node = node.next;
        }
        return tempNode.next;
    }

    //map，map的value是节点类型
    public static ListNode reverseList4(ListNode head){
        if (head == null) return null;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int i = 0;
        while (head!=null){
            map.put(i, head);
            head = head.next;
            i++;
        }
        int size = map.size();
        ListNode node = map.get(size-1);
        ListNode tempNode = node;
        for (int j = size-2; j >= 0 ; j--) {
            node.next = map.get(j);
            node = node.next;
        }
        node.next = null;
        return tempNode;
    }

    public static ListNode reverseList5(ListNode head){
        if (head == null) return null;
        ListNode newHead = null;
        while (head!=null){
            ListNode tempNode = head.next;
            head.next = newHead;
            newHead = head;
            head = tempNode;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode node = reverseList5(head);
        while (node!=null){
            System.out.println("node.val = " + node.val);
            node = node.next;
        }
    }
}

