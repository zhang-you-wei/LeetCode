package yowei.leetCode.linkedList;

import yowei.leetCode.tools.ListNode;

import java.util.LinkedList;

public class RecurList {
    public ListNode ReverseList(ListNode head) {
        if(head == null) return null;
        LinkedList<ListNode> stack = new LinkedList<>();
        while(head != null){
            ListNode cur = head;
            head = head.next;
            cur.next = null;
            stack.push(cur);
        }
        head = stack.pop();
        ListNode aux = head;
        while(stack.size() > 0){
            aux.next = stack.pop();
            aux = aux.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode res = new RecurList().ReverseList(l1);
        System.out.println(ListNode.getString(res));
    }
}
