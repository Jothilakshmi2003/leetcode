import java.util.*;

public class Solution {

    public boolean checkStrings(String s1, String s2) {
        int[] evenfreq1 = new int[26];
        int[] oddfreq1 = new int[26];
        int[] evenfreq2 = new int[26];
        int[] oddfreq2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                evenfreq1[s1.charAt(i) - 'a']++;
                evenfreq2[s2.charAt(i) - 'a']++;
            } else {
                oddfreq1[s1.charAt(i) - 'a']++;
                oddfreq2[s2.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (evenfreq1[i] != evenfreq2[i] ||
                    oddfreq1[i] != oddfreq2[i]) {
                return false;
            }
        }

        return true;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter string s1: ");
        String s1 = sc.next();

        System.out.print("Enter string s2: ");
        String s2 = sc.next();

        boolean result = sol.checkStrings(s1, s2);
        System.out.println("Can be made equal: " + result);

        sc.close();
    }
}
