package yowei.leetCode.linkedList;

import yowei.leetCode.tools.ListNode;

import java.util.LinkedList;

/**
 * 判断回文链表
 */
public class No234PalindromeLinkedList {
    /**
     * 利用额外空间
     */
    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> li = new LinkedList<>();
        while(head != null){
            li.add(head.val);
            head = head.next;
        }

        while(li.size() >= 2 ){
            if(li.removeFirst() != li.removeLast()) return false;
        }
        return true;
    }


    /**
     * 利用递归性质，从后往前遍历节点
     */
    private ListNode frontPointer;
    public boolean isPalindrome2(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
}
