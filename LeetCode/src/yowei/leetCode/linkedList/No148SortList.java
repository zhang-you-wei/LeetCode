package yowei.leetCode.linkedList;

import yowei.leetCode.tools.ListNode;

/**
 * 链表排序
 * 要求对数时间和常数空间，使用归并排序算法‘
 * 有自顶向下和自底向上两种策略，后者满足上述要求
 */
public class No148SortList {

    //定义链表节点

    public ListNode sortList(ListNode head) {
        return mergesort(head,null);
    }

    /**
     * 自顶向下递归算法
     * @param head：合并区间的头结点
     * @param tail：合并区间的尾结点（不包含）
     */
    public ListNode mergesort(ListNode head,ListNode tail){
        if(head == null) return head;
        if(head.next == tail) {
            head.next = null;        //必须置为null，将单个节点抽离出来
            return head;
        }
        ListNode fastptr = head;
        ListNode slowptr = head;

        //找到区间的中间节点
        while(fastptr.next != tail){
            fastptr = fastptr.next;
            slowptr = slowptr.next;             //这里如果将slowptr放在if里面，则区间的尾结点将包含在区间里面，31行的判断条件就需要改变
            if(fastptr.next != tail) {
                fastptr = fastptr.next;

            }
        }

        ListNode mid = slowptr;

        ListNode list1 = mergesort(head,mid);
        ListNode list2 = mergesort(mid,tail);

        ListNode list = merge(list1,list2);     //进行合并
        return list;
    }

    public ListNode merge(ListNode list1,ListNode list2){

        ListNode newlist = new ListNode();
        ListNode cueNode = newlist;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cueNode.next = list1;
                cueNode = cueNode.next;
                list1 = list1.next;
            }else{
                cueNode.next = list2;
                cueNode = cueNode.next;
                list2 = list2.next;
            }
        }
        cueNode.next = list1 == null ? list2 : list1;
        return newlist.next;
    }


    /**
     * 自底向上迭代
     * @param head:头结点
     */
    public ListNode mergesortup(ListNode head){
        int size = 0;
        ListNode auxhead = head;
        while (auxhead != null){
            size++;
            auxhead = auxhead.next;
        }
        
        //辅助头用来指向整个链表
        ListNode myHead = new ListNode(0, head);
        
        for (int subLength = 1; subLength < size; subLength <<= 1) {

            //preNode指向每轮已归并部分的最后一个节点，curNode指向当前操作的节点
            ListNode preNode = myHead, curNode = myHead.next;

            //进行一个步长的循环
            while (curNode != null) {
                ListNode firstPart = curNode;               //归并的第一部分头结点

                for (int i = 1; i < subLength && curNode.next != null; i++) {
                    curNode = curNode.next;
                }
                
                ListNode secondPart = curNode.next;        //第二部分头结点
                curNode.next = null;                        //第一部分尾结点的next置为null
                curNode = secondPart;


                //找到第二部分，有可能为空，未达长度时有可能退出
                for (int i = 1; i < subLength && curNode != null && curNode.next != null; i++) {
                    curNode = curNode.next;
                }

                //下一组数据
                ListNode next = null;
                if (curNode != null) {
                    next = curNode.next;
                    curNode.next = null;
                }
                
                ListNode merged = merge(firstPart, secondPart);

                preNode.next = merged;
                while (preNode.next != null) {
                    preNode = preNode.next;
                }
                curNode = next;
            }
        }
        return myHead.next;         //myHead始终指向归并后链表的头结点

        /*ListNode myhead = new ListNode();
        myhead.next = head;
        for (int mergesize = 1;  mergesize < size; mergesize <<= 1) {
            ListNode firstPart = myhead.next;
            ListNode secondPart = myhead.next;
            ListNode auxmyhead = myhead;
            
            while (firstPart != null){
                for (int i = 0; i < mergesize - 1 && secondPart.next != null ; i++) {
                    secondPart = secondPart.next;
                }
                ListNode last = secondPart;
                secondPart = secondPart.next;
                last.next = null;

                ListNode nextFirstNode = secondPart;
                for (int j = 0; j < mergesize - 1 && nextFirstNode != null && nextFirstNode.next != null ; j++) {
                    nextFirstNode = nextFirstNode.next;
                }
                last = nextFirstNode;
                nextFirstNode = nextFirstNode.next;
                last.next = null;

                ListNode merged = merge(firstPart, secondPart);
                auxmyhead.next = merged;
                while (auxmyhead.next != null) {
                    auxmyhead = auxmyhead.next;
                }
                firstPart = nextFirstNode;
                secondPart = firstPart;
            }
        }

        return myhead.next;*/
    }





}
