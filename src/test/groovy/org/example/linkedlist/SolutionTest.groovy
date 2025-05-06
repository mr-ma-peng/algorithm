package org.example.linkedlist

import spock.lang.Specification

class SolutionTest extends Specification {

    private Solution solution

    def setup() {
        solution = new Solution()
    }

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
}
