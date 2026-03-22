import java.util.*;

public class Solution {

    public boolean findRotation(int[][] mat, int[][] target) {
        if (compare(mat, target))
            return true;

        int count = 3;
        while (count > 0) {
            mat = rotate(mat);
            if (compare(mat, target))
                return true;
            count--;
        }
        return false;
    }

    private boolean compare(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] != target[i][j])
                    return false;
        return true;
    }

    private int[][] rotate(int[][] mat) {
        int n = mat.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[n - 1 - j][i] = mat[i][j];
            }
        }

        return res;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter matrix size (n): ");
        int n = sc.nextInt();

        int[][] mat = new int[n][n];
        int[][] target = new int[n][n];

        System.out.println("Enter matrix (mat):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter target matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                target[i][j] = sc.nextInt();
            }
        }

        boolean result = sol.findRotation(mat, target);

        System.out.println("Can match by rotation: " + result);

        sc.close();
    }
}
