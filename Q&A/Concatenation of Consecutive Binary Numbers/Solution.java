import java.util.*;

public class Solution {

    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long res = 0;
        int bits = 0;

        for (int i = 1; i <= n; i++) {
            // If i is power of 2, increase bit length
            if ((i & (i - 1)) == 0)
                bits++;

            res = ((res << bits) | i) % MOD;
        }

        return (int) res;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        int result = sol.concatenatedBinary(n);

        System.out.println("Concatenated Binary Result: " + result);

        sc.close();
    }
}
