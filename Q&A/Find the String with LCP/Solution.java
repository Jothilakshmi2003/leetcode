import java.util.*;

public class Solution {

    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        int[] group = new int[n];
        Arrays.fill(group, -1);

        int curGroup = 0;

        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                if (curGroup == 26)
                    return "";

                group[i] = curGroup++;

                for (int j = i + 1; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        group[j] = group[i];
                    }
                }
            }
        }

        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (char) ('a' + group[i]);
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (ans[i] == ans[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }

        return new String(ans);
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter size n: ");
        int n = sc.nextInt();

        int[][] lcp = new int[n][n];

        System.out.println("Enter LCP matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lcp[i][j] = sc.nextInt();
            }
        }

        String result = sol.findTheString(lcp);

        if (result.isEmpty()) {
            System.out.println("No valid string exists");
        } else {
            System.out.println("Result string: " + result);
        }

        sc.close();
    }
}
