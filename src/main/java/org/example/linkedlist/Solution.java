package org.example.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

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

    public ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummy = new ListNode<>(-1);
        ListNode<Integer> p = dummy;
        ListNode<Integer> p1 = l1;
        ListNode<Integer> p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val >= p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

    public ListNode<Integer> partition(ListNode<Integer> head, int x) {
        ListNode<Integer> dummy1 = new ListNode<>(-1);
        ListNode<Integer> dummy2 = new ListNode<>(-1);
        ListNode<Integer> p1 = dummy1;
        ListNode<Integer> p2 = dummy2;
        ListNode<Integer> p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode<Integer> temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;

        return dummy1.next;
    }

    public ListNode<Integer> mergeKLists(ListNode<Integer>[] lists) {
        if (lists.length == 0) return null;
        ListNode<Integer> dummy = new ListNode<>(-1);
        ListNode<Integer> p = dummy;
        PriorityQueue<ListNode<Integer>> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode<Integer> item : lists) {
            if (item != null) {
                pq.add(item);
            }
        }
        while (!pq.isEmpty()) {
            ListNode<Integer> node = pq.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
    }

    public ListNode<Integer> findFromEnd(ListNode<Integer> head, int k) {
        ListNode<Integer> p1 = head;
        ListNode<Integer> p2 = head;
        int index = 0;
        while (p1 != null) {
            if (index >= k) {
                p2 = p2.next;
            }
            p1 = p1.next;
            index++;
        }
        return p2;
    }

    public ListNode<Integer> removeNthFromEnd(ListNode<Integer> head, int n) {
        ListNode<Integer> dummy = new ListNode<>(-1);
        dummy.next = head;
        ListNode<Integer> fromEnd = findFromEnd(head, n + 1);
        fromEnd.next = fromEnd.next.next;
        return dummy.next;
    }
}