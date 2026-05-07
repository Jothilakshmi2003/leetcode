import java.util.*;

class Solution {

    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        int[] preMax = new int[n];

        // Prefix maximum
        preMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }

        int sufMin = Integer.MAX_VALUE;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            if (preMax[i] > sufMin) {

                // Handle last index safely
                if (i == n - 1)
                    ans[i] = preMax[i];
                else
                    ans[i] = ans[i + 1];

            } else {
                ans[i] = preMax[i];
            }

            sufMin = Math.min(sufMin, nums[i]);
        }

        return ans;
    }

    // Helper method to print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
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

        int[] result = obj.maxValue(nums);

        System.out.println("Result array:");
        printArray(result);

        sc.close();
    }
}