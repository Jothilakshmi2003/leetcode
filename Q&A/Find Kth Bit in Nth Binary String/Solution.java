import java.util.*;

public class Solution {

    public char findKthBit(int n, int k) {
        if (n == 1)
            return '0';

        int len = (1 << n) - 1;
        int mid = (len + 1) / 2;

        if (k == mid)
            return '1';
        if (k < mid)
            return findKthBit(n - 1, k);

        char c = findKthBit(n - 1, len - k + 1);
        return c == '0' ? '1' : '0';
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        char result = sol.findKthBit(n, k);

        System.out.println("The kth bit is: " + result);

        sc.close();
    }
}
