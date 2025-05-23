package org.example.linkedlist

import spock.lang.Specification

class SolutionTest extends Specification {

    private Solution solution = new Solution()

    def "test deleteDuplicates removes duplicates correctly"() {
        given: "A linked list with duplicates: 1 -> 1 -> 1 -> null"
            IntListNode head = new IntListNode(1, new IntListNode(1, new IntListNode(1)))

        when: "Remove duplicates"
            IntListNode result = solution.deleteDuplicates(head)

        then: "Result should be 1 -> null"
            result.val == 1
            result.next == null
    }

    def "test deleteDuplicates with mixed duplicates"() {
        given: "A linked list: 1 -> 1 -> 2 -> 2 -> 3 -> null"
            IntListNode head = new IntListNode(1, new IntListNode(1, new IntListNode(2, new IntListNode(2, new IntListNode(3)))))

        when: "Remove duplicates"
            IntListNode result = solution.deleteDuplicates(head)

        then: "Result should be 1 -> 2 -> 3 -> null"
            result.val == 1
            result.next.val == 2
            result.next.next.val == 3
            result.next.next.next == null
    }

    def "test deleteDuplicates with no duplicates"() {
        given: "A linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null"
            IntListNode head = new IntListNode(1, new IntListNode(2, new IntListNode(3, new IntListNode(4, new IntListNode(5)))))

        when: "Remove duplicates"
            IntListNode result = solution.deleteDuplicates(head)

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
            IntListNode head = null

        when: "Remove duplicates"
            IntListNode result = solution.deleteDuplicates(head)

        then: "Result should be null"
            result == null
    }

    def "test rotateRight rotates list correctly"() {
        given: "A linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null"
            IntListNode head = new IntListNode(1, new IntListNode(2, new IntListNode(3, new IntListNode(4, new IntListNode(5)))))

        when: "Rotate right by 2 positions"
            IntListNode result = solution.rotateRight(head, 2)

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
            IntListNode head = new IntListNode(1, new IntListNode(2, new IntListNode(3)))

        when: "Rotate right by 4 positions (length is 3)"
            IntListNode result = solution.rotateRight(head, 4)

        then: "Result should be 3 -> 1 -> 2 -> null"
            result.val == 3
            result.next.val == 1
            result.next.next.val == 2
            result.next.next.next == null
    }

    def "test rotateRight with k equals to length"() {
        given: "A linked list: 1 -> 2 -> 3 -> 4 -> null"
            IntListNode head = new IntListNode(1, new IntListNode(2, new IntListNode(3, new IntListNode(4))))

        when: "Rotate right by 4 positions (length is 4)"
            IntListNode result = solution.rotateRight(head, 4)

        then: "Result should remain unchanged: 1 -> 2 -> 3 -> 4 -> null"
            result.val == 1
            result.next.val == 2
            result.next.next.val == 3
            result.next.next.next.val == 4
            result.next.next.next.next == null
    }

    def "test rotateRight with empty list"() {
        given: "Null input"
            IntListNode head = null

        when: "Rotate right by 2 positions"
            IntListNode result = solution.rotateRight(head, 2)

        then: "Result should be null"
            result == null
    }

    def "test rotateRight with single node"() {
        given: "A single-node linked list: 1 -> null"
            IntListNode head = new IntListNode(1)

        when: "Rotate right by 5 positions"
            IntListNode result = solution.rotateRight(head, 5)

        then: "Result should remain unchanged: 1 -> null"
            result.val == 1
            result.next == null
    }

    def "test mergeTwoLists merges two sorted lists correctly"() {
        given: "Two sorted linked lists"
            IntListNode l1 = new IntListNode(1, new IntListNode(2, new IntListNode(4)))
            IntListNode l2 = new IntListNode(1, new IntListNode(3, new IntListNode(4)))

        when: "Merge the two lists"
            IntListNode result = solution.mergeTwoLists(l1, l2)

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
            IntListNode l1 = null
            IntListNode l2 = null

        when: "Merge the two lists"
            IntListNode result = solution.mergeTwoLists(l1, l2)

        then: "Result should be null"
            result == null
    }

    def "test mergeTwoLists with one list empty"() {
        given: "One list is empty"
            IntListNode l1 = null
            IntListNode l2 = new IntListNode(0)

        when: "Merge the two lists"
            IntListNode result = solution.mergeTwoLists(l1, l2)

        then: "Result should be [0]"
            result.val == 0
            result.next == null
    }

    def "test mergeTwoLists with one element in each list"() {
        given: "Each list has one element"
            IntListNode l1 = new IntListNode(2)
            IntListNode l2 = new IntListNode(1)

        when: "Merge the two lists"
            IntListNode result = solution.mergeTwoLists(l1, l2)

        then: "Result should be [1, 2]"
            result.val == 1
            result.next.val == 2
            result.next.next == null
    }

    def "test mergeTwoLists with duplicate elements"() {
        given: "Each list contains duplicates"
            IntListNode l1 = new IntListNode(1, new IntListNode(1, new IntListNode(1)))
            IntListNode l2 = new IntListNode(2, new IntListNode(2))

        when: "Merge the two lists"
            IntListNode result = solution.mergeTwoLists(l1, l2)

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
            IntListNode head = new IntListNode(1, new IntListNode(2, new IntListNode(3, new IntListNode(4, new IntListNode(5)))))

        when: "Find 2nd node from end"
            IntListNode result = solution.findFromEnd(head, 2)

        then: "Result should be node with value 4"
            result.val == 4
    }

    def "test findFromEnd with k equals to list length"() {
        given: "A linked list: 1 -> 2 -> 3 -> null"
            IntListNode head = new IntListNode(1, new IntListNode(2, new IntListNode(3)))

        when: "Find 3rd node from end (head)"
            IntListNode result = solution.findFromEnd(head, 3)

        then: "Result should be node with value 1"
            result.val == 1
    }

    def "test findFromEnd with empty list"() {
        given: "Null input"
            IntListNode head = null

        when: "Find 2nd node from end"
            IntListNode result = solution.findFromEnd(head, 2)

        then: "Result should be null"
            result == null
    }

    def "test middleNode finds the middle node correctly"() {
        given: "A linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null"
            IntListNode head = new IntListNode(1, new IntListNode(2, new IntListNode(3, new IntListNode(4, new IntListNode(5)))))

        when: "Find the middle node"
            IntListNode result = solution.middleNode(head)

        then: "Result should be node with value 3"
            result.val == 3
    }

    def "test partition with x"() {
        given: "A linked list: 1 -> 4 -> 3 -> 2 -> 5 -> 2 -> null"
            IntListNode head = new IntListNode(1, new IntListNode(4, new IntListNode(3, new IntListNode(2, new IntListNode(5, new IntListNode(2))))))

        when: "Partition the list with x=3"
            IntListNode result = solution.partition(head, 3)

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
            IntListNode head = null

        when: "Partition the list with x=5"
            IntListNode result = solution.partition(head, 5)

        then: "Result should be null"
            result == null
    }

    def "test partition with all elements greater than x"() {
        given: "A linked list: 4 -> 5 -> 6 -> null"
            IntListNode head = new IntListNode(4, new IntListNode(5, new IntListNode(6)))

        when: "Partition the list with x=3"
            IntListNode result = solution.partition(head, 3)

        then: "Result should be 4 -> 5 -> 6 -> null"
            result.val == 4
            result.next.val == 5
            result.next.next.val == 6
            result.next.next.next == null
    }

    def "test partition with all elements less than x"() {
        given: "A linked list: 1 -> 2 -> 3 -> null"
            IntListNode head = new IntListNode(1, new IntListNode(2, new IntListNode(3)))

        when: "Partition the list with x=4"
            IntListNode result = solution.partition(head, 4)

        then: "Result should be 1 -> 2 -> 3 -> null"
            result.val == 1
            result.next.val == 2
            result.next.next.val == 3
            result.next.next.next == null
    }

    def "test mergeKLists with normal input"() {
        given: "Three sorted linked lists"
            IntListNode l1 = new IntListNode(1, new IntListNode(4, new IntListNode(5)))
            IntListNode l2 = new IntListNode(1, new IntListNode(3, new IntListNode(4)))
            IntListNode l3 = new IntListNode(2, new IntListNode(6))
            IntListNode[] lists = [l1, l2, l3] as IntListNode[]

        when: "Merge the lists"
            IntListNode result = solution.mergeKLists(lists)

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
            IntListNode[] lists = [] as IntListNode[]

        when: "Merge the lists"
            IntListNode result = solution.mergeKLists(lists)

        then: "Result should be null"
            result == null
    }

    def "test mergeKLists with all lists null"() {
        given: "An array of null linked lists"
            IntListNode[] lists = [null, null, null] as IntListNode[]

        when: "Merge the lists"
            IntListNode result = solution.mergeKLists(lists)

        then: "Result should be null"
            result == null
    }

    def "test mergeKLists with single list"() {
        given: "A single linked list"
            IntListNode l1 = new IntListNode(1, new IntListNode(4, new IntListNode(5)))
            IntListNode[] lists = [l1] as IntListNode[]

        when: "Merge the lists"
            IntListNode result = solution.mergeKLists(lists)

        then: "Result should be the same as the input list"
            result.val == 1
            result.next.val == 4
            result.next.next.val == 5
            result.next.next.next == null
    }

    def "test mergeKLists with mixed null and non-null lists"() {
        given: "An array with some null and some non-null linked lists"
            IntListNode l1 = new IntListNode(1, new IntListNode(4, new IntListNode(5)))
            IntListNode l2 = null
            IntListNode l3 = new IntListNode(2, new IntListNode(6))
            IntListNode[] lists = [l1, l2, l3] as IntListNode[]

        when: "Merge the lists"
            IntListNode result = solution.mergeKLists(lists)

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
            IntListNode head = new IntListNode(1, new IntListNode(2, new IntListNode(3, new IntListNode(4, new IntListNode(5)))))

        when: "Remove the 2nd node from end (value 4)"
            IntListNode result = solution.removeNthFromEnd(head, 2)

        then: "Result should be 1 -> 2 -> 3 -> 5 -> null"
            result.val == 1
            result.next.val == 2
            result.next.next.val == 3
            result.next.next.next.val == 5
            result.next.next.next.next == null
    }

    def "test removeNthFromEnd removes last node"() {
        given: "A linked list: 1 -> 2 -> 3 -> null"
            IntListNode head = new IntListNode(1, new IntListNode(2, new IntListNode(3)))

        when: "Remove the 1st node from end (last node 3)"
            IntListNode result = solution.removeNthFromEnd(head, 1)

        then: "Result should be 1 -> 2 -> null"
            result.val == 1
            result.next.val == 2
            result.next.next == null
    }

    def "test hasCycle detects cycle in linked list"() {
        given: "A linked list with a cycle"
            IntListNode head = new IntListNode(3)
            IntListNode node2 = new IntListNode(2)
            IntListNode node0 = new IntListNode(0)
            IntListNode node4 = new IntListNode(4)
            head.next = node2
            node2.next = node0
            node0.next = node4
            node4.next = node2  // Cycle: 4 -> 2

        when: "Check for cycle"
            boolean result = solution.hasCycle(head)

        then: "Result should be true"
            result
    }

    def "test hasCycle returns false for null input"() {
        given: "Null input"
            IntListNode head = null

        when: "Check for cycle"
            boolean result = solution.hasCycle(head)

        then: "Result should be false"
            !result
    }

    def "test hasCycle returns false for non-cyclic list"() {
        given: "A non-cyclic linked list"
            IntListNode head = new IntListNode(1, new IntListNode(2, new IntListNode(3)))

        when: "Check for cycle"
            boolean result = solution.hasCycle(head)

        then: "Result should be false"
            !result
    }

    def "test detectCycle finds entry node of cycle"() {
        given: "A linked list with a cycle"
            IntListNode head = new IntListNode(3)
            IntListNode node2 = new IntListNode(2)
            IntListNode node0 = new IntListNode(0)
            IntListNode node4 = new IntListNode(4)
            head.next = node2
            node2.next = node0
            node0.next = node4
            node4.next = node2  // Cycle: 2 -> 0 -> 4 -> 2

        when: "Detect cycle"
            IntListNode result = solution.detectCycle(head)

        then: "Result should be the entry node of the cycle (node2)"
            result.val == 2
    }

    def "test detectCycle returns null for non-cyclic list"() {
        given: "A non-cyclic linked list"
            IntListNode head = new IntListNode(1, new IntListNode(2, new IntListNode(3)))

        when: "Detect cycle"
            IntListNode result = solution.detectCycle(head)

        then: "Result should be null"
            result == null
    }

    def "test detectCycle returns null for empty list"() {
        given: "Null input"
            IntListNode head = null

        when: "Detect cycle"
            IntListNode result = solution.detectCycle(head)

        then: "Result should be null"
            result == null
    }

    def "test getIntersectionNode finds intersection at middle node"() {
        given: "Two linked lists intersecting at middle node"
            IntListNode common = new IntListNode(8, new IntListNode(4, new IntListNode(5)))
            IntListNode headA = new IntListNode(4, new IntListNode(1, common))
            IntListNode headB = new IntListNode(5, new IntListNode(6, new IntListNode(1, common)))

        when:
            IntListNode result = solution.getIntersectionNode(headA, headB)

        then:
            result.val == 8
            result.next.val == 4
            result.next.next.val == 5
    }

    def "test getIntersectionNode returns null for no intersection"() {
        given: "Two non-intersecting linked lists"
            IntListNode headA = new IntListNode(1, new IntListNode(2))
            IntListNode headB = new IntListNode(3, new IntListNode(4))

        when:
            IntListNode result = solution.getIntersectionNode(headA, headB)

        then:
            result == null
    }

    def "test getIntersectionNode with one empty list"() {
        given: "One empty list and one non-empty list"
            IntListNode headA = null
            IntListNode headB = new IntListNode(1, new IntListNode(2))

        when:
            IntListNode result = solution.getIntersectionNode(headA, headB)

        then:
            result == null
    }

    def "test getIntersectionNode with both lists empty"() {
        given: "Both lists are empty"
            IntListNode headA = null
            IntListNode headB = null

        when:
            IntListNode result = solution.getIntersectionNode(headA, headB)

        then:
            result == null
    }
}
