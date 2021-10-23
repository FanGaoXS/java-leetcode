package subject143;

import datastruct.ListNode;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2021/09/03/18:10
 * @Description:
 */
class Solution {

    public static void reorderList(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int i = 0;
        //迭代链表，并且将结点依次放入按照位置（key）——>节点对象（value）的方式存入
        while (head!=null){
            map.put(i,head);
            head = head.next;
            i++;
        }
        int size = map.size();
        ListNode tempRoot = map.get(0);         //临时根节点
        head = tempRoot;                        //存储此时临时根节点的地址也就是l0的地址
        int left = 1;                           //左指针
        int right = size - 1;                   //右指针
        boolean flag = true;                    //标识位：便于区分连接左边还是右边
        while (left <= right){
            if (flag){          //连接右边，也就是从ln开始
                tempRoot.next = map.get(right);
                right --;
            } else {            //连接左边，也就是从l1开始
                tempRoot.next = map.get(left);
                left ++;
            }
            tempRoot = tempRoot.next; //迭代临时节点
            flag = !flag;       //flag取反，为了左右交替插入
        }
        tempRoot.next = null; //置此时临时节点的next为null
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList(root);
        while (root!=null){
            System.out.println("root = " + root);
            root = root.next;
        }
    }

}
