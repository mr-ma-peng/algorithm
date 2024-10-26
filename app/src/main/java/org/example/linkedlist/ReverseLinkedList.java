package org.example.linkedlist;

public class ReverseLinkedList<T> {

    public static class Node<T> {
        public final T data;
        public Node<T> next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList<T> {
        public Node<T> head;
        public LinkedList() {
            this.head = null;
        }

        public void append(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public void printList() {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public void reverse() {
            Node<T> prev = null;
            Node<T> current = head;
            while (current != null) {
                Node<T> next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.print("Original list: ");
        list.printList();

        list.reverse();

        System.out.print("Reversed list: ");
        list.printList();
    }
}
