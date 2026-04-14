import java.util.*;

public class Solution {
    long[][] dp;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int n = robot.size();
        int m = factory.length;

        dp = new long[n][m];
        for (long[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 0, robot, factory);
    }

    private long solve(int i, int j, List<Integer> robot, int[][] factory) {
        int n = robot.size();
        int m = factory.length;

        if (i == n)
            return 0; // all robots assigned
        if (j == m)
            return (long) 1e15; // no factory left

        if (dp[i][j] != -1)
            return dp[i][j];

        // option 1: skip factory
        long res = solve(i, j + 1, robot, factory);

        long cost = 0;
        int pos = factory[j][0];
        int limit = factory[j][1];

        // option 2: assign robots to this factory
        for (int k = 0; k < limit && i + k < n; k++) {
            cost += Math.abs(robot.get(i + k) - pos);
            res = Math.min(res, cost + solve(i + k + 1, j + 1, robot, factory));
        }

        return dp[i][j] = res;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter number of robots: ");
        int n = sc.nextInt();

        List<Integer> robot = new ArrayList<>();
        System.out.println("Enter robot positions:");
        for (int i = 0; i < n; i++) {
            robot.add(sc.nextInt());
        }

        System.out.print("Enter number of factories: ");
        int m = sc.nextInt();

        int[][] factory = new int[m][2];
        System.out.println("Enter factory position and limit:");
        for (int i = 0; i < m; i++) {
            factory[i][0] = sc.nextInt(); // position
            factory[i][1] = sc.nextInt(); // capacity
        }

        long result = sol.minimumTotalDistance(robot, factory);
        System.out.println("Minimum total distance: " + result);

        sc.close();
    }
}
