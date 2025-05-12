package org.example.linkedlist;

public class Solution {
    public ListNode<Integer> deleteDuplicates(ListNode<Integer> head) {
        if (head == null) return null;
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        while (fast != null) {
            if (!fast.val.equals(slow.val)) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    public ListNode<Integer> rotateRight(ListNode<Integer> head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        int length = 1;
        ListNode<Integer> tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k %= length;
        if (k == 0) {
            return head;
        }
        tail.next = head;

        ListNode<Integer> newTail = head;
        ListNode<Integer> newHead;

        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
