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
    
    def "test preorder traversal"() {
        when:
        def root = new TreeNode(1)
        root.left = new TreeNode(2)
        root.right = new TreeNode(3)
        root.left.left = new TreeNode(4)
        root.left.right = new TreeNode(5)
        
        def solution = new Solution()
        
        then:
        solution.preorderTraversal(root) == [1, 2, 4, 5, 3]
    }
    
    def "test preorder traversal with null left"() {
        when:
        def root = new TreeNode(1)
        root.right = new TreeNode(2)
        root.right.left = new TreeNode(3)
        
        def solution = new Solution()
        
        then:
        solution.preorderTraversal(root) == [1, 2, 3]
    }
    
    def "test preorder traversal with null right"() {
        when:
        def root = new TreeNode(1)
        root.left = new TreeNode(2)
        root.left.left = new TreeNode(3)
        
        def solution = new Solution()
        
        then:
        solution.preorderTraversal(root) == [1, 2, 3]
    }
    
    def "test preorder traversal of single node"() {
        when:
        def root = new TreeNode(1)
        def solution = new Solution()
        
        then:
        solution.preorderTraversal(root) == [1]
    }
    
    def "test preorder traversal of empty tree"() {
        when:
        def solution = new Solution()
        
        then:
        solution.preorderTraversal(null).isEmpty()
    }
    
    def "test diameter of binary tree"() {
        when:
        def root = new TreeNode(1)
        root.left = new TreeNode(2)
        root.right = new TreeNode(3)
        root.left.left = new TreeNode(4)
        root.left.right = new TreeNode(5)
        
        def solution = new Solution()
        
        then:
        solution.diameterOfBinaryTree(root) == 3
    }
}