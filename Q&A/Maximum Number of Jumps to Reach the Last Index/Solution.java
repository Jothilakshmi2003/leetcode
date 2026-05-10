import java.util.*;

class Solution {

    public int maximumJumps(int[] nums, int target) {

        int n = nums.length;

        // dp[i] stores maximum jumps to reach index i
        int[] dp = new int[n];

        // Mark all indices unreachable
        Arrays.fill(dp, -1);

        // Starting index needs 0 jumps
        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            // Check all previous indices
            for (int j = 0; j < i; j++) {

                // Valid jump and previous index reachable
                if (Math.abs(nums[i] - nums[j]) <= target && dp[j] != -1) {

                    // Update maximum jumps
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        Solution obj = new Solution();

        int result = obj.maximumJumps(nums, target);

        System.out.println("Maximum jumps possible: " + result);

        sc.close();
    }
}
