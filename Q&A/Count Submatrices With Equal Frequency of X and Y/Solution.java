import java.util.*;

public class Solution {

    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] sumX = new int[cols];
        int[] sumY = new int[cols];
        int res = 0;

        for (int i = 0; i < rows; i++) {
            int rx = 0, ry = 0;

            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'X')
                    rx++;
                else if (grid[i][j] == 'Y')
                    ry++;

                sumX[j] += rx;
                sumY[j] += ry;

                if (sumX[j] > 0 && sumX[j] == sumY[j])
                    res++;
            }
        }

        return res;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();

        char[][] grid = new char[r][c];

        System.out.println("Enter grid (X / Y / .):");
        for (int i = 0; i < r; i++) {
            String row = sc.next();
            for (int j = 0; j < c; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        int result = sol.numberOfSubmatrices(grid);
        System.out.println("Number of valid submatrices: " + result);

        sc.close();
    }
}
