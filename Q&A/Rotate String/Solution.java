import java.util.*;

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        return (s + s).contains(goal);
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        System.out.print("Enter string goal: ");
        String goal = sc.nextLine();

        Solution obj = new Solution();
        boolean result = obj.rotateString(s, goal);

        System.out.println("Can rotate to match: " + result);

        sc.close();
    }
}