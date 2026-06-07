import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public TreeNode createBinaryTree(int[][] descriptions) {

        HashMap<Integer, TreeNode> mp = new HashMap<>();
        HashMap<Integer, Integer> root = new HashMap<>();

        for (int[] d : descriptions) {

            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];

            if (!mp.containsKey(parent)) {
                mp.put(parent, new TreeNode(parent));
            }

            if (!mp.containsKey(child)) {
                mp.put(child, new TreeNode(child));
            }

            if (isLeft == 1) {
                mp.get(parent).left = mp.get(child);
            } else {
                mp.get(parent).right = mp.get(child);
            }

            if (root.getOrDefault(parent, 0) != -1) {
                root.put(parent, 1);
            }

            root.put(child, -1);
        }

        int rootVal = 0;

        for (Map.Entry<Integer, Integer> entry : root.entrySet()) {
            if (entry.getValue() == 1) {
                rootVal = entry.getKey();
                break;
            }
        }

        return mp.get(rootVal);
    }

    // Level Order Traversal
    public static void printLevelOrder(TreeNode root) {

        if (root == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            System.out.print(node.val + " ");

            if (node.left != null)
                q.offer(node.left);

            if (node.right != null)
                q.offer(node.right);
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of descriptions: ");
        int n = sc.nextInt();

        int[][] descriptions = new int[n][3];

        System.out.println("Enter descriptions (parent child isLeft):");

        for (int i = 0; i < n; i++) {
            descriptions[i][0] = sc.nextInt();
            descriptions[i][1] = sc.nextInt();
            descriptions[i][2] = sc.nextInt();
        }

        Solution obj = new Solution();

        TreeNode root = obj.createBinaryTree(descriptions);

        System.out.println("Level Order Traversal of Constructed Tree:");

        printLevelOrder(root);

        sc.close();
    }
}