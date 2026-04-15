import java.util.*;

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int clockwise = (i - startIndex + n) % n;
                int anticlockwise = (startIndex - i + n) % n;
                ans = Math.min(ans, Math.min(clockwise, anticlockwise));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        String[] words = { "hello", "i", "am", "leetcode", "hello" };
        String target = "hello";
        int startIndex = 1;

        int result = obj.closestTarget(words, target, startIndex);

        System.out.println("Closest Distance: " + result);
    }
}
