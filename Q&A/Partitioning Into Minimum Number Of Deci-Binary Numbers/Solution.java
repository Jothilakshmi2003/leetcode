import java.util.*;

public class Solution {

    public int minPartitions(String n) {
        int ans = 0;
        for (int i = 0; i < n.length(); ++i) {
            ans = Math.max(ans, n.charAt(i) - '0');
        }
        return ans;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter a number string: ");
        String input = sc.nextLine();

        int result = sol.minPartitions(input);

        System.out.println("Minimum number of deci-binary numbers needed: " + result);

        sc.close();
    }
}
