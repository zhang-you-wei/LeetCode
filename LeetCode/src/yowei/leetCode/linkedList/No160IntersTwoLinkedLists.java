package yowei.leetCode.linkedList;

import yowei.leetCode.tools.ListNode;

/**
 * 找到两个链表相较的那个节点
 * 让两个链表走完一遍自己后再走一遍对方的路径，这样两个走的总距离相同，若有相交点，则必定在该点汇合然后一同走到结尾
 * 当没有相交点时，两个链表最后同时走到null处退出循环
 */
public class No160IntersTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;

        while(curA != curB){
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}
