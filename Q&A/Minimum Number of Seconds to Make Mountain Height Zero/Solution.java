import java.util.*;

public class Solution {

    public long minNumberOfSeconds(int height, int[] times) {
        long lo = 1, hi = 10000000000000000L;

        while (lo < hi) {
            long mid = (lo + hi) >> 1;
            long tot = 0;

            for (int i = 0; i < times.length && tot < height; i++) {
                tot += (long) (Math.sqrt((double) mid / times[i] * 2 + 0.25) - 0.5);
            }

            if (tot >= height)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter mountain height: ");
        int height = sc.nextInt();

        System.out.print("Enter number of workers: ");
        int n = sc.nextInt();

        int[] times = new int[n];

        System.out.println("Enter time for each worker:");
        for (int i = 0; i < n; i++) {
            times[i] = sc.nextInt();
        }

        long result = sol.minNumberOfSeconds(height, times);

        System.out.println("Minimum number of seconds: " + result);

        sc.close();
    }
}
