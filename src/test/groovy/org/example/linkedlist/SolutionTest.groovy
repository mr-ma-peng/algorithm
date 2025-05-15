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

    def "test findFromEnd finds correct node from end"() {
        given: "A linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null"
            ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5)))))

        when: "Find 2nd node from end"
            ListNode<Integer> result = solution.findFromEnd(head, 2)

        then: "Result should be node with value 4"
            result.val == 4
    }

    def "test findFromEnd with k equals to list length"() {
        given: "A linked list: 1 -> 2 -> 3 -> null"
            ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3)))

        when: "Find 3rd node from end (head)"
            ListNode<Integer> result = solution.findFromEnd(head, 3)

        then: "Result should be node with value 1"
            result.val == 1
    }

    def "test findFromEnd with empty list"() {
        given: "Null input"
            ListNode<Integer> head = null

        when: "Find 2nd node from end"
            ListNode<Integer> result = solution.findFromEnd(head, 2)

        then: "Result should be null"
            result == null
    }

    def "test partition with x"() {
        given: "A linked list: 1 -> 4 -> 3 -> 2 -> 5 -> 2 -> null"
            ListNode<Integer> head = new ListNode<>(1, new ListNode<>(4, new ListNode<>(3, new ListNode<>(2, new ListNode<>(5, new ListNode<>(2))))))

        when: "Partition the list with x=3"
            ListNode<Integer> result = solution.partition(head, 3)

        then: "Result should be 1 -> 2 -> 2 -> 4 -> 3 -> 5 -> null"
            result.val == 1
            result.next.val == 2
            result.next.next.val == 2
            result.next.next.next.val == 4
            result.next.next.next.next.val == 3
            result.next.next.next.next.next.val == 5
            result.next.next.next.next.next.next == null
    }

    def "test partition with empty list"() {
        given: "Null input"
            ListNode<Integer> head = null

        when: "Partition the list with x=5"
            ListNode<Integer> result = solution.partition(head, 5)

        then: "Result should be null"
            result == null
    }

    def "test partition with all elements greater than x"() {
        given: "A linked list: 4 -> 5 -> 6 -> null"
            ListNode<Integer> head = new ListNode<>(4, new ListNode<>(5, new ListNode<>(6)))

        when: "Partition the list with x=3"
            ListNode<Integer> result = solution.partition(head, 3)

        then: "Result should be 4 -> 5 -> 6 -> null"
            result.val == 4
            result.next.val == 5
            result.next.next.val == 6
            result.next.next.next == null
    }

    def "test partition with all elements less than x"() {
        given: "A linked list: 1 -> 2 -> 3 -> null"
            ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3)))

        when: "Partition the list with x=4"
            ListNode<Integer> result = solution.partition(head, 4)

        then: "Result should be 1 -> 2 -> 3 -> null"
            result.val == 1
            result.next.val == 2
            result.next.next.val == 3
            result.next.next.next == null
    }

    def "test mergeKLists with normal input"() {
        given: "Three sorted linked lists"
            ListNode<Integer> l1 = new ListNode<>(1, new ListNode<>(4, new ListNode<>(5)))
            ListNode<Integer> l2 = new ListNode<>(1, new ListNode<>(3, new ListNode<>(4)))
            ListNode<Integer> l3 = new ListNode<>(2, new ListNode<>(6))
            ListNode<Integer>[] lists = [l1, l2, l3] as ListNode<Integer>[]

        when: "Merge the lists"
            ListNode<Integer> result = solution.mergeKLists(lists)

        then: "Result should be [1, 1, 2, 3, 4, 4, 5, 6]"
            result.val == 1
            result.next.val == 1
            result.next.next.val == 2
            result.next.next.next.val == 3
            result.next.next.next.next.val == 4
            result.next.next.next.next.next.val == 4
            result.next.next.next.next.next.next.val == 5
            result.next.next.next.next.next.next.next.val == 6
            result.next.next.next.next.next.next.next.next == null
    }

    def "test mergeKLists with empty array"() {
        given: "An empty array of linked lists"
            ListNode<Integer>[] lists = [] as ListNode<Integer>[]

        when: "Merge the lists"
            ListNode<Integer> result = solution.mergeKLists(lists)

        then: "Result should be null"
            result == null
    }

    def "test mergeKLists with all lists null"() {
        given: "An array of null linked lists"
            ListNode<Integer>[] lists = [null, null, null] as ListNode<Integer>[]

        when: "Merge the lists"
            ListNode<Integer> result = solution.mergeKLists(lists)

        then: "Result should be null"
            result == null
    }

    def "test mergeKLists with single list"() {
        given: "A single linked list"
            ListNode<Integer> l1 = new ListNode<>(1, new ListNode<>(4, new ListNode<>(5)))
            ListNode<Integer>[] lists = [l1] as ListNode<Integer>[]

        when: "Merge the lists"
            ListNode<Integer> result = solution.mergeKLists(lists)

        then: "Result should be the same as the input list"
            result.val == 1
            result.next.val == 4
            result.next.next.val == 5
            result.next.next.next == null
    }

    def "test mergeKLists with mixed null and non-null lists"() {
        given: "An array with some null and some non-null linked lists"
            ListNode<Integer> l1 = new ListNode<>(1, new ListNode<>(4, new ListNode<>(5)))
            ListNode<Integer> l2 = null
            ListNode<Integer> l3 = new ListNode<>(2, new ListNode<>(6))
            ListNode<Integer>[] lists = [l1, l2, l3] as ListNode<Integer>[]

        when: "Merge the lists"
            ListNode<Integer> result = solution.mergeKLists(lists)

        then: "Result should be [1, 2, 4, 5, 6]"
            result.val == 1
            result.next.val == 2
            result.next.next.val == 4
            result.next.next.next.val == 5
            result.next.next.next.next.val == 6
            result.next.next.next.next.next == null
    }

    def "test removeNthFromEnd removes middle node"() {
        given: "A linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null"
            ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5)))))

        when: "Remove the 2nd node from end (value 4)"
            ListNode<Integer> result = solution.removeNthFromEnd(head, 2)

        then: "Result should be 1 -> 2 -> 3 -> 5 -> null"
            result.val == 1
            result.next.val == 2
            result.next.next.val == 3
            result.next.next.next.val == 5
            result.next.next.next.next == null
    }

    def "test removeNthFromEnd removes last node"() {
        given: "A linked list: 1 -> 2 -> 3 -> null"
            ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3)))

        when: "Remove the 1st node from end (last node 3)"
            ListNode<Integer> result = solution.removeNthFromEnd(head, 1)

        then: "Result should be 1 -> 2 -> null"
            result.val == 1
            result.next.val == 2
            result.next.next == null
    }
}
