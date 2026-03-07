import java.util.*;

public class Solution {

    public int minFlips(String s) {
        int n = s.length();
        String ss = s + s;

        int ans = Integer.MAX_VALUE;
        int diff1 = 0, diff2 = 0;

        for (int i = 0; i < ss.length(); i++) {

            char exp1 = (i % 2 == 0) ? '0' : '1';
            char exp2 = (i % 2 == 0) ? '1' : '0';

            if (ss.charAt(i) != exp1)
                diff1++;
            if (ss.charAt(i) != exp2)
                diff2++;

            if (i >= n) {
                char p1 = ((i - n) % 2 == 0) ? '0' : '1';
                char p2 = ((i - n) % 2 == 0) ? '1' : '0';

                if (ss.charAt(i - n) != p1)
                    diff1--;
                if (ss.charAt(i - n) != p2)
                    diff2--;
            }

            if (i >= n - 1) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter binary string: ");
        String s = sc.nextLine();

        int result = sol.minFlips(s);

        System.out.println("Minimum flips needed: " + result);

        sc.close();
    }
}
