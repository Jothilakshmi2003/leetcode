import java.util.*;

public class Solution {

    public int numSteps(String s) {
        int N = s.length();

        int operations = 0;
        int carry = 0;

        for (int i = N - 1; i > 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;

            if (digit % 2 == 1) {
                operations += 2; // add 1 (makes it even) + divide by 2
                carry = 1;
            } else {
                operations++; // just divide by 2
            }
        }

        return operations + carry;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter a binary string: ");
        String input = sc.nextLine();

        int result = sol.numSteps(input);

        System.out.println("Number of steps to reduce to 1: " + result);

        sc.close();
    }
}
