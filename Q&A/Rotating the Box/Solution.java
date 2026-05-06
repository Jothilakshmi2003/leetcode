import java.util.*;

class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        char[][] result = new char[n][m];

        // Step 1: Rotate
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        // Step 2: Apply gravity
        int[] emptyIndex = new int[m];
        Arrays.fill(emptyIndex, n - 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {

                if (result[i][j] == '#') {
                    if (emptyIndex[j] != i) {
                        result[emptyIndex[j]][j] = '#';
                        result[i][j] = '.';
                    }
                    emptyIndex[j]--;

                } else if (result[i][j] == '*') {
                    emptyIndex[j] = i - 1;
                }
            }
        }

        return result;
    }

    // Helper to print grid
    public static void printGrid(char[][] grid) {
        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows (m): ");
        int m = sc.nextInt();

        System.out.print("Enter cols (n): ");
        int n = sc.nextInt();

        char[][] box = new char[m][n];

        System.out.println("Enter grid (# for stone, * for obstacle, . for empty):");
        for (int i = 0; i < m; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                box[i][j] = row.charAt(j);
            }
        }

        System.out.println("Original Box:");
        printGrid(box);

        Solution obj = new Solution();
        char[][] result = obj.rotateTheBox(box);

        System.out.println("After Rotation + Gravity:");
        printGrid(result);

        sc.close();
    }
}