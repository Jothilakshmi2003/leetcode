import java.util.*;

public class Solution {

    public int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                min = Math.min(min, Math.abs(start - i));
            }
        }

        return min;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        int result = sol.getMinDistance(nums, target, start);
        System.out.println("Minimum distance: " + result);

        sc.close();
    }
}
