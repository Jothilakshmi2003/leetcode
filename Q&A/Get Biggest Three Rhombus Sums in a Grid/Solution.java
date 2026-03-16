import java.util.*;

public class Solution {

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                set.add(grid[i][j]);

                for (int k = 1;; k++) {
                    if (i - k < 0 || i + k >= m || j - k < 0 || j + k >= n)
                        break;

                    int sum = 0;

                    int r = i - k, c = j;
                    for (int t = 0; t < k; t++)
                        sum += grid[r + t][c + t];

                    r = i;
                    c = j + k;
                    for (int t = 0; t < k; t++)
                        sum += grid[r + t][c - t];

                    r = i + k;
                    c = j;
                    for (int t = 0; t < k; t++)
                        sum += grid[r - t][c - t];

                    r = i;
                    c = j - k;
                    for (int t = 0; t < k; t++)
                        sum += grid[r - t][c + t];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        for (int i = size - 1; i >= 0; i--) {
            ans[i] = set.pollLast();
        }

        return ans;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter rows: ");
        int m = sc.nextInt();

        System.out.print("Enter columns: ");
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        System.out.println("Enter grid values:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[] result = sol.getBiggestThree(grid);

        System.out.println("Top Rhombus Sums:");
        for (int x : result) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}
