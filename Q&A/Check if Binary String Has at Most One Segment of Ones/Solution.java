import java.util.*;

public class Solution {

    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter a binary string: ");
        String s = sc.nextLine();

        boolean result = sol.checkOnesSegment(s);

        System.out.println("Has only one segment of 1s: " + result);

        sc.close();
    }
}
