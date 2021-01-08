package yowei.leetCode.linkedList;

import yowei.leetCode.tools.ListNode;

/**
 * 合并两个有序链表
 */
public class No21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        while(l1 != null && l2!=null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        cur.next = l1==null ? l2 : l1;
        return res.next;
    }
}
