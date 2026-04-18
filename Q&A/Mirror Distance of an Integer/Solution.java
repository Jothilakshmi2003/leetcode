import java.util.*;

class Solution {
    private int revnum(int a) {
        if (a / 10 == 0)
            return a;
        String s = new StringBuilder(Integer.toString(a)).reverse().toString();
        return Integer.parseInt(s);
    }

    public int mirrorDistance(int n) {
        return Math.abs(n - revnum(n));
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int n = 1234; // sample input
        int result = obj.mirrorDistance(n);

        System.out.println("Mirror Distance: " + result);
    }
}