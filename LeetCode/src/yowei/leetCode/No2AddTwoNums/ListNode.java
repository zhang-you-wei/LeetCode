package yowei.leetCode.No2AddTwoNums;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public boolean hasNext(){
        return this.next != null;
    }

    @Override
    public String toString() {
        return  val + "->";
    }
}
