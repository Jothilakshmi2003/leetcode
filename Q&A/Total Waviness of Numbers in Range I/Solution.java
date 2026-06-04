import java.util.*;

class Solution {

    public int totalWaviness(int num1, int num2) {

        int ans = 0;

        for (int x = num1; x <= num2; x++) {

            String s = String.valueOf(x);

            for (int i = 1; i < s.length() - 1; i++) {

                if ((s.charAt(i) > s.charAt(i - 1) &&
                     s.charAt(i) > s.charAt(i + 1)) ||

                    (s.charAt(i) < s.charAt(i - 1) &&
                     s.charAt(i) < s.charAt(i + 1))) {

                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num1: ");
        int num1 = sc.nextInt();

        System.out.print("Enter num2: ");
        int num2 = sc.nextInt();

        Solution obj = new Solution();

        int result = obj.totalWaviness(num1, num2);

        System.out.println("Total Waviness: " + result);

        sc.close();
    }
}