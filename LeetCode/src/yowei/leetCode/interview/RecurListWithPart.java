package yowei.leetCode.interview;

import yowei.leetCode.tools.ListNode;

public class RecurListWithPart {


    public ListNode reverseLinkedList (ListNode head, int n) {
        if(n == 1) return head;


        ListNode totalHead = new ListNode();        //方便结果输出，当做第0段

        ListNode curPartTail = totalHead;       //当前段的尾
        ListNode lastPartTail = totalHead;       //上一段的尾

        ListNode cur = head;            //反转时头部指针
        //ListNode last = head;

        while(cur != null){
            ListNode last = null;       //反转时上一个节点指针

            curPartTail = cur;          //进入一个新段，段头节点就是反转后的位尾结点

            for(int i = 1;i<=n;i++){

                ListNode tmp = cur.next;
                cur.next = last;
                last = cur;
                cur = tmp;
                if(cur == null) {
                    break;
                }
            }
            lastPartTail.next = last;
            lastPartTail = curPartTail;
        }
        return totalHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        ListNode head = ListNode.getListNode(arr);
        RecurListWithPart rlw = new RecurListWithPart();
        ListNode res = rlw.reverseLinkedList(head, 3);
        String string = ListNode.getString(res);
        System.out.println(string);
    }
}
