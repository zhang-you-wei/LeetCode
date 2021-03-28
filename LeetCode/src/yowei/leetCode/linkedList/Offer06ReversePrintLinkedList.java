package yowei.leetCode.linkedList;

import yowei.leetCode.tools.ListNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Offer06ReversePrintLinkedList {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int len = stack.size();
        int[] res = new int[len];
        for(int i = 0;i < len;i++){
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ListNode list = ListNode.getListNode(arr);
        int[] res = new Offer06ReversePrintLinkedList().reversePrint(list);
        System.out.println(Arrays.toString(res));
    }
}
