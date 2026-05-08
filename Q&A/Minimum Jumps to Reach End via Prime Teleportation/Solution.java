import java.util.*;

class Solution {

    static final int LIMIT = 1000005;
    static boolean[] prime = new boolean[LIMIT];

    // Sieve
    static {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= 1000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < LIMIT; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    public int minJumps(int[] nums) {

        int n = nums.length;

        int max = nums[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] head = new int[max + 1];
        Arrays.fill(head, -1);

        int[] next = new int[n];

        // Build linked indices for each value
        for (int i = 0; i < n; i++) {
            next[i] = head[nums[i]];
            head[nums[i]] = i;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        Set<Integer> seen = new HashSet<>();

        while (!queue.isEmpty()) {

            int dq = queue.poll();

            if (dq == n - 1)
                return dp[dq];

            // Move right
            int right = dq + 1;

            if (right < n && dp[right] == -1) {
                dp[right] = dp[dq] + 1;
                queue.add(right);
            }

            // Move left
            int left = dq - 1;

            if (left >= 0 && dp[left] == -1) {
                dp[left] = dp[dq] + 1;
                queue.add(left);
            }

            int val = nums[dq];

            // Prime-based jumps
            if (!prime[val] && !seen.contains(val)) {

                seen.add(val);

                for (int i = val; i <= max; i += val) {

                    for (int j = head[i]; j != -1; j = next[j]) {

                        if (dp[j] == -1) {
                            dp[j] = dp[dq] + 1;
                            queue.add(j);
                        }
                    }

                    head[i] = -1;
                }
            }
        }

        return -1;
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

        Solution obj = new Solution();

        int result = obj.minJumps(nums);

        System.out.println("Minimum jumps: " + result);

        sc.close();
    }
}