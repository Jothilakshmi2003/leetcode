import java.util.*;

public class Solution {

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeros = new int[n];

        // Count trailing zeros in each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
                count++;
            }
            zeros[i] = count;
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            int needed = n - i - 1;
            int j = i;

            // Find a row with enough trailing zeros
            while (j < n && zeros[j] < needed)
                j++;

            if (j == n)
                return -1;

            // Bubble it up
            while (j > i) {
                int temp = zeros[j];
                zeros[j] = zeros[j - 1];
                zeros[j - 1] = temp;
                j--;
                swaps++;
            }
        }

        return swaps;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter grid size (n): ");
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        System.out.println("Enter grid values (0 or 1):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = sol.minSwaps(grid);

        System.out.println("Minimum swaps required: " + result);

        sc.close();
    }
}
