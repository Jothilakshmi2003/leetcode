import java.util.*;

public class Solution {

    // Definition for binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        return DFS(root, 0);
    }

    public int DFS(TreeNode rt, int x) {
        if (rt == null)
            return 0;

        x = x * 2 + rt.val;

        // Check if leaf node
        if (rt.left == null && rt.right == null) {
            return x;
        }

        return DFS(rt.left, x) + DFS(rt.right, x);
    }

    // Main method for VS Code
    public static void main(String[] args) {

        Solution sol = new Solution();

        // Creating sample tree manually
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        int result = sol.sumRootToLeaf(root);

        System.out.println("Sum of Root-to-Leaf Binary Numbers: " + result);
    }
}
