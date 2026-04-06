import java.util.*;

public class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        int x = 0, y = 0;
        int dirIdx = 0;

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -2) {
                dirIdx = (dirIdx - 1 + 4) % 4;
            } else if (cmd == -1) {
                dirIdx = (dirIdx + 1) % 4;
            } else {
                int dx = dirs[dirIdx][0];
                int dy = dirs[dirIdx][1];

                for (int step = 0; step < cmd; step++) {
                    int nextX = x + dx;
                    int nextY = y + dy;

                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break;
                    }

                    x = nextX;
                    y = nextY;
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter number of commands: ");
        int n = sc.nextInt();

        int[] commands = new int[n];
        System.out.println("Enter commands:");
        for (int i = 0; i < n; i++) {
            commands[i] = sc.nextInt();
        }

        System.out.print("Enter number of obstacles: ");
        int k = sc.nextInt();

        int[][] obstacles = new int[k][2];
        System.out.println("Enter obstacle coordinates:");
        for (int i = 0; i < k; i++) {
            obstacles[i][0] = sc.nextInt();
            obstacles[i][1] = sc.nextInt();
        }

        int result = sol.robotSim(commands, obstacles);
        System.out.println("Maximum distance squared: " + result);

        sc.close();
    }
}
