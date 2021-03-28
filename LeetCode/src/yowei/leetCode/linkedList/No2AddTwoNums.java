package yowei.leetCode.linkedList;

import yowei.leetCode.tools.ListNode;

public class No2AddTwoNums {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        add(l1,l2,res,0);
        return res;
    }

    public void add(ListNode l1, ListNode l2,ListNode res,int step){
        int add_num1;
        int add_num2;

        if(l1!=null) add_num1 = l1.val;
        else add_num1 = 0;
        if(l2!=null) add_num2 = l2.val;
        else add_num2 = 0;
        int a = (add_num1 + add_num2)%10;
        int b = (add_num1 + add_num2)/10;

        if(add_num1 ==0 && add_num2 ==0 && step==0) return;
        else {
            l1 = l1.next;
            l2 = l2.next;
            res.next = new ListNode(a + step);
            add(l1, l2, res.next,b);
        }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int carry = 0;
        while(l1!=null && l2!=null){
            int num = (l1.val + l2.val + carry)%10;
            carry = (l1.val + l2.val + carry)/10;
            cur.next = new ListNode(num);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        cur.next = l1 == null ? l2 : l1;
        while(carry != 0){
            if(cur.next == null) {
                cur.next = new ListNode(1);
                break;
            }
            else{
                int next_val = cur.next.val;
                cur.next.val = (next_val + carry)%10;
                carry = (next_val + carry)/10;
                cur = cur.next;
            }
        }


        return head.next;

    }

    public static void main(String[] args) {
        ListNode add1 = new ListNode(3);
        add1.next = new ListNode(7);
//        ListNode cur = add1;
//        for(int i = 0;i<6;i++){
//            cur.next = new ListNode(9);
//            cur = cur.next;
//        }

        ListNode add2 = new ListNode(9);
        add2.next = new ListNode(2);
//        cur = add2;
//        for(int i = 0;i<3;i++){
//            cur.next = new ListNode(9);
//            cur = cur.next;
//        }

        System.out.println(ListNode.getString(add1));
        System.out.println(ListNode.getString(add2));

        ListNode res = new No2AddTwoNums().addTwoNumbers2(add1, add2);
        System.out.println(ListNode.getString(res));
    }


}
