import java.util.*;

public class Solution {

    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        boolean result = sol.hasAlternatingBits(n);

        System.out.println("Has alternating bits? " + result);

        sc.close();
    }
}
