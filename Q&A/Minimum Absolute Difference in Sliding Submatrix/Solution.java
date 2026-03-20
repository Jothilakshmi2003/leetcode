import java.util.*;

public class Solution {

    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n - k + 1][m - k + 1];

        if (k == 1)
            return result;

        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < m - k + 1; j++) {

                int[] arr = new int[k * k];
                int idx = 0;

                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        arr[idx++] = grid[r][c];
                    }
                }

                Arrays.sort(arr);

                int min = Integer.MAX_VALUE;

                for (int l = 1; l < k * k; l++) {
                    if (arr[l] != arr[l - 1]) {
                        min = Math.min(min, arr[l] - arr[l - 1]);
                    }
                }

                if (min == Integer.MAX_VALUE) {
                    min = 0;
                }

                result[i][j] = min;
            }
        }

        return result;
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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int[][] result = sol.minAbsDiff(grid, k);

        System.out.println("Result matrix:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
