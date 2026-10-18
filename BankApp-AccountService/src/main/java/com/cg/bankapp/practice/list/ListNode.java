package com.cg.bankapp.practice.list;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
public class ListNode implements Comparable<ListNode>, Comparator<ListNode> {
    private int val;
    private ListNode next;
    @Getter
    private static List<ListNode> NODES = new ArrayList<>();

    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
        NODES.add(this);
    }


    @Override
    public String toString() {
        ListNode temp=this;
        StringBuilder sb=new StringBuilder();
        while (temp.next != null){
            sb.append(temp.val).append(" -> ");
            temp=temp.next;
        }
        sb.append(temp.val);
        return sb.toString();
    }

    @Override
    public int compareTo(ListNode o) {
        return Integer.compare(this.val, o.val);
    }

    @Override
    public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val, o2.val);
    }

    static class ReverseList {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }
    }
    class DoubleNode {
        public ListNode doubleEveryNode(ListNode head) {
            ListNode current = head;
            while (current != null) {
                current.val *= 2;
                current = current.next;
            }
            return head;
        }
    }
}