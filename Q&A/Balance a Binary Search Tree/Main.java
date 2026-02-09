import java.util.*;

// TreeNode definition
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

// Your Solution class
class Solution {
    List<Integer> nums;

    public TreeNode balanceBST(TreeNode root) {
        nums = new ArrayList<>();
        getNumbers(root);
        return balanceTree(0, nums.size() - 1);
    }

    private void getNumbers(TreeNode node) {
        if (node == null)
            return;
        getNumbers(node.left);
        nums.add(node.val);
        getNumbers(node.right);
    }

    private TreeNode balanceTree(int l, int r) {
        if (l > r)
            return null;
        int middleIdx = l + (r - l) / 2;
        TreeNode res = new TreeNode(nums.get(middleIdx));
        res.left = balanceTree(l, middleIdx - 1);
        res.right = balanceTree(middleIdx + 1, r);
        return res;
    }
}

// Main class for VS Code
public class Main {

    // Helper function to print inorder
    static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        // Creating an unbalanced BST
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        Solution sol = new Solution();
        TreeNode balancedRoot = sol.balanceBST(root);

        System.out.println("Inorder of Balanced BST:");
        printInorder(balancedRoot);
    }
}
