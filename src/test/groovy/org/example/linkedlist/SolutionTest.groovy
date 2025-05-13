package org.example.linkedlist

import spock.lang.Specification

class SolutionTest extends Specification {

    private Solution solution = new Solution()

    def "test deleteDuplicates removes duplicates correctly"() {
        given: "A linked list with duplicates: 1 -> 1 -> 1 -> null"
            ListNode<Integer> head = new ListNode<>(1, new ListNode<>(1, new ListNode<>(1)))

        when: "Remove duplicates"
            ListNode<Integer> result = solution.deleteDuplicates(head)

        then: "Result should be 1 -> null"
            result.val == 1
            result.next == null
    }

    def "test deleteDuplicates with mixed duplicates"() {
        given: "A linked list: 1 -> 1 -> 2 -> 2 -> 3 -> null"
            ListNode<Integer> head = new ListNode<>(1, new ListNode<>(1, new ListNode<>(2, new ListNode<>(2, new ListNode<>(3)))))

        when: "Remove duplicates"
            ListNode<Integer> result = solution.deleteDuplicates(head)

        then: "Result should be 1 -> 2 -> 3 -> null"
            result.val == 1
            result.next.val == 2
            result.next.next.val == 3
            result.next.next.next == null
    }

    def "test deleteDuplicates with no duplicates"() {
        given: "A linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null"
            ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5)))))

        when: "Remove duplicates"
            ListNode<Integer> result = solution.deleteDuplicates(head)

        then: "Result should remain unchanged"
            result.val == 1
            result.next.val == 2
            result.next.next.val == 3
            result.next.next.next.val == 4
            result.next.next.next.next.val == 5
            result.next.next.next.next.next == null
    }

    def "test deleteDuplicates with empty list"() {
        given: "Null input"
            ListNode<Integer> head = null

        when: "Remove duplicates"
            ListNode<Integer> result = solution.deleteDuplicates(head)

        then: "Result should be null"
            result == null
    }

    def "test rotateRight rotates list correctly"() {
        given: "A linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null"
            ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5)))))

        when: "Rotate right by 2 positions"
            ListNode<Integer> result = solution.rotateRight(head, 2)

        then: "Result should be 4 -> 5 -> 1 -> 2 -> 3 -> null"
            result.val == 4
            result.next.val == 5
            result.next.next.val == 1
            result.next.next.next.val == 2
            result.next.next.next.next.val == 3
            result.next.next.next.next.next == null
    }

    def "test rotateRight with k larger than length"() {
        given: "A linked list: 1 -> 2 -> 3 -> null"
            ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3)))

        when: "Rotate right by 4 positions (length is 3)"
            ListNode<Integer> result = solution.rotateRight(head, 4)

        then: "Result should be 3 -> 1 -> 2 -> null"
            result.val == 3
            result.next.val == 1
            result.next.next.val == 2
            result.next.next.next == null
    }

    def "test rotateRight with k equals to length"() {
        given: "A linked list: 1 -> 2 -> 3 -> 4 -> null"
            ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4))))

        when: "Rotate right by 4 positions (length is 4)"
            ListNode<Integer> result = solution.rotateRight(head, 4)

        then: "Result should remain unchanged: 1 -> 2 -> 3 -> 4 -> null"
            result.val == 1
            result.next.val == 2
            result.next.next.val == 3
            result.next.next.next.val == 4
            result.next.next.next.next == null
    }

    def "test rotateRight with empty list"() {
        given: "Null input"
            ListNode<Integer> head = null

        when: "Rotate right by 2 positions"
            ListNode<Integer> result = solution.rotateRight(head, 2)

        then: "Result should be null"
            result == null
    }

    def "test rotateRight with single node"() {
        given: "A single-node linked list: 1 -> null"
            ListNode<Integer> head = new ListNode<>(1)

        when: "Rotate right by 5 positions"
            ListNode<Integer> result = solution.rotateRight(head, 5)

        then: "Result should remain unchanged: 1 -> null"
            result.val == 1
            result.next == null
    }

    def "test mergeTwoLists merges two sorted lists correctly"() {
        given: "Two sorted linked lists"
            ListNode<Integer> l1 = new ListNode<>(1, new ListNode<>(2, new ListNode<>(4)))
            ListNode<Integer> l2 = new ListNode<>(1, new ListNode<>(3, new ListNode<>(4)))

        when: "Merge the two lists"
            ListNode<Integer> result = solution.mergeTwoLists(l1, l2)

        then: "Result should be [1, 1, 2, 3, 4, 4]"
            result.val == 1
            result.next.val == 1
            result.next.next.val == 2
            result.next.next.next.val == 3
            result.next.next.next.next.val == 4
            result.next.next.next.next.next.val == 4
            result.next.next.next.next.next.next == null
    }

    def "test mergeTwoLists with both lists empty"() {
        given: "Both lists are empty"
            ListNode<Integer> l1 = null
            ListNode<Integer> l2 = null

        when: "Merge the two lists"
            ListNode<Integer> result = solution.mergeTwoLists(l1, l2)

        then: "Result should be null"
            result == null
    }

    def "test mergeTwoLists with one list empty"() {
        given: "One list is empty"
            ListNode<Integer> l1 = null
            ListNode<Integer> l2 = new ListNode<>(0)

        when: "Merge the two lists"
            ListNode<Integer> result = solution.mergeTwoLists(l1, l2)

        then: "Result should be [0]"
            result.val == 0
            result.next == null
    }

    def "test mergeTwoLists with one element in each list"() {
        given: "Each list has one element"
            ListNode<Integer> l1 = new ListNode<>(2)
            ListNode<Integer> l2 = new ListNode<>(1)

        when: "Merge the two lists"
            ListNode<Integer> result = solution.mergeTwoLists(l1, l2)

        then: "Result should be [1, 2]"
            result.val == 1
            result.next.val == 2
            result.next.next == null
    }

    def "test mergeTwoLists with duplicate elements"() {
        given: "Each list contains duplicates"
            ListNode<Integer> l1 = new ListNode<>(1, new ListNode<>(1, new ListNode<>(1)))
            ListNode<Integer> l2 = new ListNode<>(2, new ListNode<>(2))

        when: "Merge the two lists"
            ListNode<Integer> result = solution.mergeTwoLists(l1, l2)

        then: "Result should be [1, 1, 1, 2, 2]"
            result.val == 1
            result.next.val == 1
            result.next.next.val == 1
            result.next.next.next.val == 2
            result.next.next.next.next.val == 2
            result.next.next.next.next.next == null
    }
}
