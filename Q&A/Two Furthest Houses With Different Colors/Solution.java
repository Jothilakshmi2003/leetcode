import java.util.*;

class Solution {
    public int maxDistance(int[] c) {
        int mx = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = i + 1; j < c.length; j++) {
                if (c[i] != c[j]) {
                    mx = Math.max(mx, j - i);
                }
            }
        }
        return mx;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] colors = { 1, 1, 2, 3, 1, 2 };

        int result = obj.maxDistance(colors);

        System.out.println("Maximum Distance: " + result);
    }
}