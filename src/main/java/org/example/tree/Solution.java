package org.example.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int maxDiameter = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int maxDepth = diameterOfBinaryTreeTraverse(root);
        return maxDiameter;
    }
    private int diameterOfBinaryTreeTraverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, myDiameter);
        return Math.max(leftMax, rightMax) + 1;
    }
}