package org.example.linkedlist;

public class IntListNode {
    int val;
    IntListNode next;

    public IntListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public IntListNode(int val, IntListNode next) {
        this.val = val;
        this.next = next;
    }
}

