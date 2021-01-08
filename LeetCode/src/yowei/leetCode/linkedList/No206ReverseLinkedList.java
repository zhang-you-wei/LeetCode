package yowei.leetCode.linkedList;

import yowei.leetCode.tools.ListNode;

/**
 * 翻转链表
 */
public class No206ReverseLinkedList {
    /**
     * 方法一：原地修改链表指向
     */
     public ListNode reverseList(ListNode head) {
         ListNode prev = null;
         ListNode cur = head;
         while(cur != null){
             ListNode temp = cur.next;
             cur.next = prev;
             prev = cur;
             cur = temp;
         }
         return prev;
     }

    /**
     * 方法二：利用递归性质，从后往前按顺序得到结点
     */
    ListNode res = null;
    public ListNode reverseList2(ListNode head) {
        if(head == null) return null;
        ListNode last =  reverse(head);
        return res;
    }

    private ListNode reverse(ListNode x){
        if(x.next == null) {
            res = x;
            return x;
        }
        ListNode temp  = x.next;
        x.next = null;
        reverse(temp).next = x;
        return x;
    }
}
