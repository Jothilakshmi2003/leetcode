import java.util.*;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String cur : queries) {
            if (helper(cur, dictionary))
                ans.add(cur);
        }
        return ans;
    }

    public static boolean helper(String str, String[] dictionary) {
        int ans = 0, i = 0;

        while (i < dictionary.length) {
            ans = 0;
            String cur = dictionary[i];

            for (int index = 0; index < cur.length(); index++) {
                if (str.charAt(index) != cur.charAt(index))
                    ans++;
                if (ans > 2)
                    break;
            }

            i++;
            if (ans <= 2)
                return true;
        }

        return false; // cleaner and correct
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        String[] queries = { "word", "note", "ants", "wood" };
        String[] dictionary = { "wood", "joke", "moat" };

        List<String> result = obj.twoEditWords(queries, dictionary);

        System.out.println("Result: " + result);
    }
}