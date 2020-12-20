package yowei.leetCode.twoPointer;


import yowei.leetCode.tools.ListNode;

/*
    删除链表的倒数第n和结点
    使用滑动窗口：先正序找到正数第n个结点，然后两个指针同时滑动，直至后指针指向链表尾部，
                此时前指针指向的位置即为需要删除的结点，为了方便删除该节点，找到删除结点
                的前一个结点更便利，但是需要提前排除各种特殊情况。
 */
public class No19RemNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //n为0表示不删除任何结点，直接返回原链表
        if(n == 0) return head;
        //链表长度小于等于1删除后为空直接返回
        if(head == null || head.next == null) return null;

        //定义尾结点和删除点的前一个结点
        ListNode tail = head,delformer = head;

        //郑旭移动
        for (int i = 0; i < n; i++) {
            tail = tail.next;
        }

        //判断特殊情况，要求删除倒数第n个结点即第一个结点，直接返回
        if(tail == null) return head.next;


        //窗口滑动
        while (tail.next != null){
            tail = tail.next;
            delformer = delformer.next;
        }

        //删除结点
        ListNode dec = delformer.next.next;
        delformer.next = dec;

        return head;
    }

    public static void main(String[] args) {
        No19RemNthNode solution = new No19RemNthNode();
        int[] a = {1,2,3};
        ListNode input = ListNode.getListNode(a);
        ListNode listNode = solution.removeNthFromEnd(input, 3);
        String string = ListNode.getString(listNode);
        System.out.println(string);
    }
}
