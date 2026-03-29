import java.util.*;

public class Solution {

    public boolean canBeEqual(String s1, String s2) {
        char[] even1 = new char[2], odd1 = new char[2];
        char[] even2 = new char[2], odd2 = new char[2];

        int e = 0, o = 0;

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                even1[e] = s1.charAt(i);
                even2[e] = s2.charAt(i);
                e++;
            } else {
                odd1[o] = s1.charAt(i);
                odd2[o] = s2.charAt(i);
                o++;
            }
        }

        Arrays.sort(even1);
        Arrays.sort(even2);
        Arrays.sort(odd1);
        Arrays.sort(odd2);

        return Arrays.equals(even1, even2) &&
                Arrays.equals(odd1, odd2);
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter string s1 (length 4): ");
        String s1 = sc.next();

        System.out.print("Enter string s2 (length 4): ");
        String s2 = sc.next();

        boolean result = sol.canBeEqual(s1, s2);
        System.out.println("Can be made equal: " + result);

        sc.close();
    }
}
