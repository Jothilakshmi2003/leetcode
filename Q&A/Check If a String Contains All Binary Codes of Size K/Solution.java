import java.util.*;

public class Solution {

    public boolean hasAllCodes(String s, int k) {
        HashSet<String> st = new HashSet<>();

        for (int i = 0; i + k <= s.length(); i++) {
            st.add(s.substring(i, i + k));
        }

        return st.size() == (int) Math.pow(2, k);
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter binary string: ");
        String s = sc.nextLine();

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        boolean result = sol.hasAllCodes(s, k);

        System.out.println("Contains all binary codes of size k? " + result);

        sc.close();
    }
}
