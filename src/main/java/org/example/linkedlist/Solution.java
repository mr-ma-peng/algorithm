package org.example.linkedlist;

public class Solution {
    public ListNode<Integer> deleteDuplicates(ListNode<Integer> head) {
        if (head == null) return null;
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        while (fast != null) {
            if (!fast.val.equals(slow.val)) {
                slow.next = fast;
                slow = slow.getNext();
            }
            fast = fast.getNext();
        }
        slow.next = null;
        return head;
    }
}
