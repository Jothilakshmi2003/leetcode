import java.util.Arrays;

class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = nums[((i + nums[i]) % n + n) % n];
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums = { 3, -2, 1, 4 };

        int[] ans = sol.constructTransformedArray(nums);

        System.out.println("Transformed Array:");
        System.out.println(Arrays.toString(ans));
    }
}
