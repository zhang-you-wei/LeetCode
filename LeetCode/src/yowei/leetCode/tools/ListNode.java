package yowei.leetCode.tools;

public class ListNode {
      public int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      public static ListNode getListNode(int[] arr){
          ListNode head,tail;
          head = new ListNode(arr[0]);
          tail = head;
          for (int i = 1; i < arr.length; i++) {
              ListNode cur = new ListNode(arr[i]);
              tail.next =cur;
              tail = cur;
          }
          return head;
      }

    public static String getString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.val+"->");
            head = head.next;
        }

        return sb.toString();
    }

    /*public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        ListNode listNode = new ListNode().getListNode(a);
        String string = ListNode.getString(listNode);
        System.out.println(string);
    }*/
}
