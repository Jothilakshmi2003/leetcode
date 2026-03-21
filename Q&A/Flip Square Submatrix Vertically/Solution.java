import java.util.*;

public class Solution {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int sc = y, ec = y + k - 1, sr = x;

        for (int j = sc; j <= ec; j++) {
            for (int i = 0; i < k / 2; i++) {
                int tmp = grid[sr + i][j];
                grid[sr + i][j] = grid[sr + k - i - 1][j];
                grid[sr + k - i - 1][j] = tmp;
            }
        }
        return grid;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter rows: ");
        int n = sc.nextInt();

        System.out.print("Enter columns: ");
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        System.out.println("Enter grid values:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting row (x): ");
        int x = sc.nextInt();

        System.out.print("Enter starting column (y): ");
        int y = sc.nextInt();

        System.out.print("Enter size k: ");
        int k = sc.nextInt();

        int[][] result = sol.reverseSubmatrix(grid, x, y, k);

        System.out.println("Updated Grid:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
