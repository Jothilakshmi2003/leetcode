import java.util.*;

class Solution {

    private int calFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < ls.length; i++) {
            mini = Math.min(mini, ls[i] + ld[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < ws.length; i++) {
            ans = Math.min(
                    ans,
                    Math.max(mini, ws[i]) + wd[i]);
        }

        return ans;
    }

    public int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {

        return Math.min(
                calFinishTime(
                        landStartTime,
                        landDuration,
                        waterStartTime,
                        waterDuration),
                calFinishTime(
                        waterStartTime,
                        waterDuration,
                        landStartTime,
                        landDuration));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of land rides: ");
        int n = sc.nextInt();

        int[] landStartTime = new int[n];
        int[] landDuration = new int[n];

        System.out.println("Enter land ride start times:");
        for (int i = 0; i < n; i++) {
            landStartTime[i] = sc.nextInt();
        }

        System.out.println("Enter land ride durations:");
        for (int i = 0; i < n; i++) {
            landDuration[i] = sc.nextInt();
        }

        System.out.print("Enter number of water rides: ");
        int m = sc.nextInt();

        int[] waterStartTime = new int[m];
        int[] waterDuration = new int[m];

        System.out.println("Enter water ride start times:");
        for (int i = 0; i < m; i++) {
            waterStartTime[i] = sc.nextInt();
        }

        System.out.println("Enter water ride durations:");
        for (int i = 0; i < m; i++) {
            waterDuration[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        int result = obj.earliestFinishTime(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration);

        System.out.println("Earliest Finish Time: " + result);

        sc.close();
    }
}
