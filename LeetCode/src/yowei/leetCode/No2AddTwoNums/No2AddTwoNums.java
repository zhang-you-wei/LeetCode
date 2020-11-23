package yowei.leetCode.No2AddTwoNums;

public class No2AddTwoNums {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        add(l1,l2,res,0);
        if(res.hasNext()) return res.next;
        else return res;
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

    public static void main(String[] args) {
        ListNode add1 = new ListNode(2);
        add1.next = new ListNode(4);
        add1.next.next = new ListNode(3);

        ListNode add2 = new ListNode(5);
        add2.next = new ListNode(6);
        add2.next.next = new ListNode(4);

        ListNode res = new No2AddTwoNums().addTwoNumbers(add1, add2);

        while (res.hasNext()){
            System.out.print(res);
            res = res.next;
        }
        System.out.println(res);
    }


}
