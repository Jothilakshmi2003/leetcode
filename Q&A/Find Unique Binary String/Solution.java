import java.util.*;

public class Solution {

    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;
        int size = (int) Math.pow(2, n);

        int[] nu = new int[size];

        for (String num : nums) {
            int val = Integer.parseInt(num, 2);
            nu[val]++;
        }

        for (int i = 0; i < size; i++) {
            if (nu[i] == 0) {
                String ans = Integer.toBinaryString(i);
                return "0".repeat(n - ans.length()) + ans;
            }
        }

        return "0".repeat(n);
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter number of binary strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] nums = new String[n];

        System.out.println("Enter binary strings:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLine();
        }

        String result = sol.findDifferentBinaryString(nums);

        System.out.println("Different Binary String: " + result);

        sc.close();
    }
}
