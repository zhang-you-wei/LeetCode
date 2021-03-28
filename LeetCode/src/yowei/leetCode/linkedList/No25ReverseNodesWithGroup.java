package yowei.leetCode.linkedList;

import yowei.leetCode.tools.ListNode;

/**
 * k个一组翻转链表，剩余不足k的部分保持原样
 */
public class No25ReverseNodesWithGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode myHead = new ListNode(0);
        ListNode tail = myHead;
        while(head != null){
            ListNode pre = null;
            ListNode tmpTail = head;
            if(!isEnough(head,k)){
                tail.next = head;
                break;
            }else{
                for(int i = 1;i<=k;i++){
                    ListNode tmp = head.next;
                    head.next = pre;
                    pre = head;
                    head= tmp;
                }
                tail.next = pre;
                tail = tmpTail;
            }
        }
        return myHead.next;
    }

    private boolean isEnough(ListNode t,int k){
        for(int i = 0;i<k;i++){
            if(t == null) return false;
            t = t.next;
        }
        return true;
    }


}
