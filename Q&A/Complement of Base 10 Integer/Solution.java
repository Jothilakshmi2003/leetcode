import java.util.*;

public class Solution {

    public int bitwiseComplement(int n) {
        if (n == 0)
            return 1;

        int ans = 0;
        int i = 0;

        while (n > 0) {
            int bit = n % 2;

            if (bit == 0) {
                ans += Math.pow(2, i);
            }

            i++;
            n /= 2;
        }

        return ans;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int result = sol.bitwiseComplement(n);

        System.out.println("Bitwise Complement: " + result);

        sc.close();
    }
}
