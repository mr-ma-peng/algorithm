package org.example.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public IntListNode deleteDuplicates(IntListNode head) {
        if (head == null) return null;
        IntListNode slow = head;
        IntListNode fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    public IntListNode rotateRight(IntListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        int length = 1;
        IntListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k %= length;
        if (k == 0) {
            return head;
        }
        tail.next = head;

        IntListNode newTail = head;
        IntListNode newHead;

        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public IntListNode mergeTwoLists(IntListNode l1, IntListNode l2) {
        IntListNode dummy = new IntListNode(-1);
        IntListNode p = dummy;
        IntListNode p1 = l1;
        IntListNode p2 = l2;
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

    public IntListNode partition(IntListNode head, int x) {
        IntListNode dummy1 = new IntListNode(-1);
        IntListNode dummy2 = new IntListNode(-1);
        IntListNode p1 = dummy1;
        IntListNode p2 = dummy2;
        IntListNode p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            IntListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;

        return dummy1.next;
    }

    public IntListNode mergeKLists(IntListNode[] lists) {
        if (lists.length == 0) return null;
        IntListNode dummy = new IntListNode(-1);
        IntListNode p = dummy;
        PriorityQueue<IntListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for (IntListNode item : lists) {
            if (item != null) {
                pq.add(item);
            }
        }
        while (!pq.isEmpty()) {
            IntListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
    }

    public IntListNode findFromEnd(IntListNode head, int k) {
        IntListNode p1 = head;
        IntListNode p2 = head;
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

    public IntListNode removeNthFromEnd(IntListNode head, int n) {
        IntListNode dummy = new IntListNode(-1);
        dummy.next = head;
        IntListNode fromEnd = findFromEnd(head, n + 1);
        fromEnd.next = fromEnd.next.next;
        return dummy.next;
    }

    public IntListNode middleNode(IntListNode head) {
        IntListNode slow = head;
        IntListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasCycle(IntListNode head) {
        IntListNode slow = head;
        IntListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public IntListNode detectCycle(IntListNode head) {
        IntListNode slow = head;
        IntListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public IntListNode getIntersectionNode(IntListNode headA, IntListNode headB) {
        IntListNode p1 = headA;
        IntListNode p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}