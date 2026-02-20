import java.util.*;

public class Solution {

    public String makeLargestSpecial(String s) {
        int count = 0;
        int i = 0;
        List<String> res = new ArrayList<>();

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                String inner = makeLargestSpecial(s.substring(i + 1, j));
                res.add("1" + inner + "0");
                i = j + 1;
            }
        }

        Collections.sort(res, Collections.reverseOrder());

        StringBuilder ans = new StringBuilder();
        for (String str : res) {
            ans.append(str);
        }

        return ans.toString();
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter a special binary string: ");
        String input = sc.nextLine();

        String result = sol.makeLargestSpecial(input);

        System.out.println("Largest Special String: " + result);

        sc.close();
    }
}
