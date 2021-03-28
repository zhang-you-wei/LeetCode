package yowei.leetCode.linkedList;

import yowei.leetCode.tools.ListNode;

/**
 * 排序奇升偶降链表
 * 1-8-3-6-5-4-7-2  ->  1-2-3-4-5-6-7-8-null
 * 分三步：1.奇偶位置分别提取出来
 *        2.反转链表
 *        3.合并有序链表
 */
public class InterviewSortOddAndEven {

    public static ListNode process(ListNode root){
        //第一步：按奇偶位置提取链表
        if(root == null || root.next == null) return root;

        ListNode odd = root;
        ListNode even = root.next;
        ListNode curOdd = odd;
        ListNode curEven = even;
        while(curEven != null){
            curOdd.next = curEven.next;
            curOdd = curOdd.next;
            if(curOdd == null) break;
            curEven.next = curOdd.next;
            curEven = curEven.next;
        }

        //第二步
        ListNode pre = null;
        ListNode cur = even;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        even = pre;

        //第三步
        pre = new ListNode(0);
        cur = pre;
        while(odd != null && even != null){
            if(odd.val <= even.val){
                cur.next = odd;
                odd = odd.next;
            }else {
                cur.next = even;
                even = even.next;
            }
            cur = cur.next;
        }
        cur.next = odd == null ? even : odd;

        return pre.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,3,6,5,4,7,2};
        ListNode root = ListNode.getListNode(arr);
        ListNode process = process(root);
        System.out.println(ListNode.getString(process));
    }

}
