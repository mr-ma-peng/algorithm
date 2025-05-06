package org.example.linkedlist;

public class Solution {
    public ListNode<Integer> deleteDuplicates(ListNode<Integer> head) {
        if (head == null) return null;
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        while (fast != null) {
            if (!fast.getVal().equals(slow.getVal())) {
                slow.setNext(fast);
                slow = slow.getNext();
            }
            fast = fast.getNext();
        }
        slow.setNext(null);
        return head;
    }
}
