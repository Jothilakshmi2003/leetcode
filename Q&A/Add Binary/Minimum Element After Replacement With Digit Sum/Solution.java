import java.util.*;

class Solution {

    public int minElement(int[] nums) {

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            int sum = 0;

            // Calculate digit sum
            while (num > 0) {

                sum += (num % 10);

                num /= 10;
            }

            ans = Math.min(ans, sum);
        }

        return ans;
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

        int result = obj.minElement(nums);

        System.out.println("Minimum digit sum: " + result);

        sc.close();
    }
}