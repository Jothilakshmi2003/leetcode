import java.util.*;

class Solution {

    public int minMoves(int[] nums, int limit) {

        int n = nums.length;

        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {

            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);

            // One move range
            diff[a + 1] -= 1;
            diff[b + limit + 1] += 1;

            // Zero move exact sum
            diff[a + b] -= 1;
            diff[a + b + 1] += 1;
        }

        int pairs = n / 2;

        // Initially assume 2 moves for every pair
        int current = pairs * 2;

        int answer = Integer.MAX_VALUE;

        for (int sum = 2; sum <= 2 * limit; sum++) {

            current += diff[sum];

            answer = Math.min(answer, current);
        }

        return answer;
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

        System.out.print("Enter limit: ");
        int limit = sc.nextInt();

        Solution obj = new Solution();

        int result = obj.minMoves(nums, limit);

        System.out.println("Minimum moves required: " + result);

        sc.close();
    }
}
