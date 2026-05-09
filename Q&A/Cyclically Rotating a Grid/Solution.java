import java.util.*;

class Solution {

    public int[][] rotateGrid(int[][] grid, int k) {

        int T = 0, L = 0;
        int B = grid.length - 1, R = grid[0].length - 1;

        while (T < B && L < R) {

            int len = B - T;
            int wid = R - L;

            int perimeter = 2 * len + 2 * wid;

            int r = k % perimeter;

            while (r-- > 0) {

                int tmp = grid[T][L];

                // Top row
                for (int i = L; i < R; i++)
                    grid[T][i] = grid[T][i + 1];

                // Right column
                for (int i = T; i < B; i++)
                    grid[i][R] = grid[i + 1][R];

                // Bottom row
                for (int i = R; i > L; i--)
                    grid[B][i] = grid[B][i - 1];

                // Left column
                for (int i = B; i > T; i--)
                    grid[i][L] = grid[i - 1][L];

                grid[T + 1][L] = tmp;
            }

            T++;
            L++;
            B--;
            R--;
        }

        return grid;
    }

    // Helper method to print matrix
    public static void printGrid(int[][] grid) {

        for (int[] row : grid) {

            for (int val : row) {
                System.out.print(val + " ");
            }

            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        System.out.println("Enter grid elements:");

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter k rotations: ");
        int k = sc.nextInt();

        Solution obj = new Solution();

        int[][] result = obj.rotateGrid(grid, k);

        System.out.println("Rotated Grid:");

        printGrid(result);

        sc.close();
    }
}