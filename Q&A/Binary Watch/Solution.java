import java.util.*;

public class Solution {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();

        for (int hours = 0; hours < 12; hours++) {
            for (int minutes = 0; minutes < 60; minutes++) {
                if (Integer.bitCount(hours) + Integer.bitCount(minutes) == turnedOn) {
                    String time = hours + ":";

                    if (minutes < 10) {
                        time += "0";
                    }

                    time += minutes;
                    ans.add(time);
                }
            }
        }
        return ans;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter number of LEDs turned on: ");
        int turnedOn = sc.nextInt();

        List<String> result = sol.readBinaryWatch(turnedOn);

        System.out.println("Possible Times:");
        for (String time : result) {
            System.out.println(time);
        }

        sc.close();
    }
}
