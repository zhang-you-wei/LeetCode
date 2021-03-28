package yowei.leetCode.linkedList;

import yowei.leetCode.tools.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 */
public class No92ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode myHead = new ListNode(0);
        ListNode tail = myHead;         //当前段的尾巴

        tail.next = head;
        for (int i = 1;i<left;i++){             //找到left节点的前一个
            tail = tail.next;
        }

        ListNode pre = null;
        head = tail.next;
        ListNode reverseTail = head;
        for(int i = left;i<=right;i++){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        reverseTail.next = head;
        tail.next = pre;
        return myHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode root = ListNode.getListNode(arr);
        ListNode res = reverseBetween(root, 2, 4);
        System.out.println(ListNode.getString(res));
    }
}
