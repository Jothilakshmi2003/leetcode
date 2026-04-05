import java.util.*;

public class Solution {

    public boolean judgeCircle(String moves) {
        int count_v = 0, count_h = 0;

        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);

            if (ch == 'U')
                count_v++;
            else if (ch == 'D')
                count_v--;
            else if (ch == 'R')
                count_h++;
            else
                count_h--;
        }

        return count_v == 0 && count_h == 0;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter moves string (U/D/L/R): ");
        String moves = sc.next();

        boolean result = sol.judgeCircle(moves);
        System.out.println("Returns to origin: " + result);

        sc.close();
    }
}
