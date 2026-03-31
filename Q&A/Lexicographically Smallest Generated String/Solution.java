import java.util.*;

public class Solution {

    public String generateString(String S, String t) {
        char[] s = S.toCharArray();
        int n = s.length;
        int m = t.length();
        char[] ans = new char[n + m - 1];
        Arrays.fill(ans, '?');

        // Process 'T'
        for (int i = 0; i < n; i++) {
            if (s[i] != 'T')
                continue;

            for (int j = 0; j < m; j++) {
                char v = ans[i + j];
                if (v != '?' && v != t.charAt(j)) {
                    return "";
                }
                ans[i + j] = t.charAt(j);
            }
        }

        char[] oldAns = ans.clone();

        // Fill remaining with 'a'
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == '?') {
                ans[i] = 'a';
            }
        }

        // Process 'F'
        for (int i = 0; i < n; i++) {
            if (s[i] != 'F')
                continue;

            if (!new String(ans, i, m).equals(t))
                continue;

            boolean ok = false;

            for (int j = i + m - 1; j >= i; j--) {
                if (oldAns[j] == '?') {
                    ans[j] = 'b';
                    ok = true;
                    break;
                }
            }

            if (!ok)
                return "";
        }

        return new String(ans);
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter S string (T/F): ");
        String S = sc.next();

        System.out.print("Enter target string t: ");
        String t = sc.next();

        String result = sol.generateString(S, t);

        if (result.isEmpty()) {
            System.out.println("No valid string can be generated");
        } else {
            System.out.println("Generated string: " + result);
        }

        sc.close();
    }
}
