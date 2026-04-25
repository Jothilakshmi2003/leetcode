import java.util.*;

class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0, blanks = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L')
                left++;
            else if (c == 'R')
                right++;
            else
                blanks++;
        }

        return Math.abs(left - right) + blanks;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        String moves = "L_RL__R"; // sample input
        int result = obj.furthestDistanceFromOrigin(moves);

        System.out.println("Furthest Distance: " + result);
    }
}