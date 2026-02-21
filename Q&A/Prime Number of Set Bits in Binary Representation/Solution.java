import java.util.*;

public class Solution {

    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);
            if (isPrime(setBits)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter left value: ");
        int left = sc.nextInt();

        System.out.print("Enter right value: ");
        int right = sc.nextInt();

        int result = sol.countPrimeSetBits(left, right);

        System.out.println("Count of numbers with prime set bits: " + result);

        sc.close();
    }
}
