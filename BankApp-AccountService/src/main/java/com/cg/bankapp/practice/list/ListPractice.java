package com.cg.bankapp.practice.list;

public class ListPractice {

    public static void main(String[] args){
        ListNode head=new ListNode(5,null);
        head.setNext(new ListNode(10,null));
        head.getNext().setNext(new ListNode(15,null));
        System.out.println(head);

        ListNode.ReverseList rl=new ListNode.ReverseList();
        ListNode reversedHead=rl.reverseList(head);
        System.out.println(reversedHead);

        ListNode.DoubleNode dn=head.new DoubleNode();
        ListNode doubledHead=dn.doubleEveryNode(reversedHead);
        System.out.println(doubledHead);

        System.out.println(ListNode.getNODES());

        System.out.println(head.compareTo(new ListNode(10)));
        System.out.println(head.compare(doubledHead,reversedHead));

        ListNode ln1=new ListNode(1);
        ListNode ln2=ln1;
        ln1.setVal(10);
        System.out.println(ln1.getVal()); // 10
        System.out.println(ln2.getVal()); // 10
    }
}
