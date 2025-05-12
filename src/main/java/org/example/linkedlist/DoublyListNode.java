package org.example.linkedlist;

class DoublyListNode<T> {
    T val;
    DoublyListNode<T> prev;
    DoublyListNode<T> next;

    DoublyListNode(T x) {
        val = x;
        this.prev = null;
        this.next = null;
    }

    DoublyListNode(T x, DoublyListNode<T> prev, DoublyListNode<T> next) {
        val = x;
        this.prev = prev;
        this.next = next;
    }
}
