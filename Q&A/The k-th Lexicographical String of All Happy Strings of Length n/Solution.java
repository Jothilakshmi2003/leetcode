import java.util.*;

public class Solution {

    public String getHappyString(int n, int k) {
        int sz = (int) Math.pow(2, n - 1);
        if (3 * sz < k)
            return "";

        String[] opts = { "bc", "ac", "ab" };
        StringBuilder res = new StringBuilder();

        if (k <= sz)
            res.append('a');
        else if (k <= 2 * sz) {
            res.append('b');
            k -= sz;
        } else {
            res.append('c');
            k -= 2 * sz;
        }

        for (int i = 1; i < n; i++) {
            sz /= 2;
            String ch = opts[res.charAt(res.length() - 1) - 'a'];

            if (k <= sz)
                res.append(ch.charAt(0));
            else {
                res.append(ch.charAt(1));
                k -= sz;
            }
        }

        return res.toString();
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        String result = sol.getHappyString(n, k);

        if (result.isEmpty())
            System.out.println("No such happy string exists.");
        else
            System.out.println("Kth Happy String: " + result);

        sc.close();
    }
}
