import java.util.*;

public class Solution {

    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        // Build heights in-place
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Integer[] row = new Integer[n];
            for (int j = 0; j < n; j++) {
                row[j] = matrix[i][j];
            }

            Arrays.sort(row, Collections.reverseOrder());

            for (int width = 1; width <= n; width++) {
                int h = row[width - 1];
                ans = Math.max(ans, h * width);
            }
        }

        return ans;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter rows: ");
        int m = sc.nextInt();

        System.out.print("Enter columns: ");
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        System.out.println("Enter matrix values (0/1):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int result = sol.largestSubmatrix(matrix);
        System.out.println("Largest Submatrix Area: " + result);

        sc.close();
    }
}
