import java.util.*;

public class Solution {

    public int binaryGap(int n) {
        int maxGap = 0;
        int bitpos = 0;
        int lastSetBit = -1;

        while (bitpos < 31) {
            if (((n >> bitpos) & 1) == 1) {
                if (lastSetBit != -1) {
                    maxGap = Math.max(maxGap, bitpos - lastSetBit);
                }
                lastSetBit = bitpos;
            }
            bitpos++;
        }
        return maxGap;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int result = sol.binaryGap(n);

        System.out.println("Maximum binary gap: " + result);

        sc.close();
    }
}
