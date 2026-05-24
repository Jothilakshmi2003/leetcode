import java.util.*;

class Solution {

    int dfs(int[] a, int[] dp, int i, int d) {

        // Already computed
        if (dp[i] != 0)
            return dp[i];

        int mx = 1;

        int n = a.length;

        // Move right
        for (int j = 1; j <= d && i + j < n; j++) {

            if (a[i] > a[i + j]) {

                mx = Math.max(mx,
                        1 + dfs(a, dp, i + j, d));

            } else {
                break;
            }
        }

        // Move left
        for (int j = 1; j <= d && i - j >= 0; j++) {

            if (a[i] > a[i - j]) {

                mx = Math.max(mx,
                        1 + dfs(a, dp, i - j, d));

            } else {
                break;
            }
        }

        return dp[i] = mx;
    }

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;

        int[] dp = new int[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {

            ans = Math.max(ans,
                    dfs(arr, dp, i, d));
        }

        return ans;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter d value: ");
        int d = sc.nextInt();

        Solution obj = new Solution();

        int result = obj.maxJumps(arr, d);

        System.out.println("Maximum jumps possible: " + result);

        sc.close();
    }
}
