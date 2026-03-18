import java.util.*;

public class Solution {

    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        long[][] sum = new long[n][m];

        sum[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < m; j++) {
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                sum[i][j] = grid[i][j]
                        + sum[i - 1][j]
                        + sum[i][j - 1]
                        - sum[i - 1][j - 1];
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sum[i][j] <= k)
                    result++;
            }
        }

        return result;
    }

    // Main method
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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = sol.countSubmatrices(grid, k);
        System.out.println("Count of submatrices with sum <= k: " + result);

        sc.close();
    }
}
