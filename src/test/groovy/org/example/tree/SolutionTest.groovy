package org.example.tree

import spock.lang.Specification

class SolutionTest extends Specification {
    def "test max depth"() {
        when:
        def root = new TreeNode(3)
        root.left = new TreeNode(9)
        root.right = new TreeNode(20)
        root.right.left = new TreeNode(15)
        root.right.right = new TreeNode(7)
        
        def solution = new Solution()
        
        then:
        solution.maxDepth(root) == 3
    }
    
    def "test empty tree"() {
        when:
        def solution = new Solution()
        
        then:
        solution.maxDepth(null) == 0
    }
    
    def "test single node tree"() {
        when:
        def root = new TreeNode(1)
        def solution = new Solution()
        
        then:
        solution.maxDepth(root) == 1
    }
}