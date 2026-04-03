import java.util.*;

public class Solution {

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        int[][] x = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            x[i][0] = robots[i];
            x[i][1] = distance[i];
        }

        Arrays.sort(x, 0, n, (a, b) -> a[0] - b[0]);
        Arrays.sort(walls);

        x[n][0] = (int) 1e9;
        x[n][1] = 0;

        // lower_bound
        java.util.function.BiFunction<int[], Integer, Integer> lowerBound = (arr, target) -> {
            int l = 0, r = arr.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (arr[mid] < target)
                    l = mid + 1;
                else
                    r = mid;
            }
            return l;
        };

        // upper_bound
        java.util.function.BiFunction<int[], Integer, Integer> upperBound = (arr, target) -> {
            int l = 0, r = arr.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if (arr[mid] <= target)
                    l = mid + 1;
                else
                    r = mid;
            }
            return l;
        };

        // count walls in [l, r]
        java.util.function.BiFunction<Integer, Integer, Integer> query = (l, r) -> {
            if (l > r)
                return 0;
            int it1 = upperBound.apply(walls, r);
            int it2 = lowerBound.apply(walls, l);
            return it1 - it2;
        };

        int[][] dp = new int[n][2];

        dp[0][0] = query.apply(x[0][0] - x[0][1], x[0][0]);

        if (n > 1) {
            dp[0][1] = query.apply(
                    x[0][0],
                    Math.min(x[1][0] - 1, x[0][0] + x[0][1]));
        } else {
            dp[0][1] = query.apply(x[0][0], x[0][0] + x[0][1]);
        }

        for (int i = 1; i < n; i++) {

            // shoot RIGHT
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) +
                    query.apply(
                            x[i][0],
                            Math.min(x[i + 1][0] - 1, x[i][0] + x[i][1]));

            // shoot LEFT (no overlap)
            dp[i][0] = dp[i - 1][0] +
                    query.apply(
                            Math.max(x[i][0] - x[i][1], x[i - 1][0] + 1),
                            x[i][0]);

            // shoot LEFT with overlap fix
            int leftStart = Math.max(x[i][0] - x[i][1], x[i - 1][0] + 1);
            int leftEnd = x[i][0];

            int overlapStart = leftStart;
            int overlapEnd = Math.min(x[i - 1][0] + x[i - 1][1], x[i][0] - 1);

            int res = dp[i - 1][1]
                    + query.apply(leftStart, leftEnd)
                    - query.apply(overlapStart, overlapEnd);

            dp[i][0] = Math.max(dp[i][0], res);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter number of robots: ");
        int n = sc.nextInt();

        int[] robots = new int[n];
        int[] distance = new int[n];

        System.out.println("Enter robot positions:");
        for (int i = 0; i < n; i++) {
            robots[i] = sc.nextInt();
        }

        System.out.println("Enter robot distances:");
        for (int i = 0; i < n; i++) {
            distance[i] = sc.nextInt();
        }

        System.out.print("Enter number of walls: ");
        int w = sc.nextInt();

        int[] walls = new int[w];
        System.out.println("Enter wall positions:");
        for (int i = 0; i < w; i++) {
            walls[i] = sc.nextInt();
        }

        int result = sol.maxWalls(robots, distance, walls);
        System.out.println("Maximum walls destroyed: " + result);

        sc.close();
    }
}
