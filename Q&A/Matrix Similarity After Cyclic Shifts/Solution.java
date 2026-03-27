import java.util.*;

public class Solution {

    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k %= n; // reduce k < n

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    // even row → left shift
                    if (mat[i][j] != mat[i][(j + k) % n]) {
                        return false;
                    }
                } else {
                    // odd row → right shift
                    if (mat[i][j] != mat[i][(j - k + n) % n]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter rows: ");
        int m = sc.nextInt();

        System.out.print("Enter columns: ");
        int n = sc.nextInt();

        int[][] mat = new int[m][n];

        System.out.println("Enter matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        boolean result = sol.areSimilar(mat, k);
        System.out.println("Are matrices similar: " + result);

        sc.close();
    }
}
