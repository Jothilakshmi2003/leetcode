import java.util.*;

class Solution {

    public boolean canReach(int[] arr, int start) {

        int n = arr.length;

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(start);
        vis[start] = true;

        while (!q.isEmpty()) {

            int i = q.poll();

            // Reached value 0
            if (arr[i] == 0)
                return true;

            int forward = i + arr[i];
            int backward = i - arr[i];

            // Move forward
            if (forward < n && !vis[forward]) {
                vis[forward] = true;
                q.offer(forward);
            }

            // Move backward
            if (backward >= 0 && !vis[backward]) {
                vis[backward] = true;
                q.offer(backward);
            }
        }

        return false;
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

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        Solution obj = new Solution();

        boolean result = obj.canReach(arr, start);

        System.out.println("Can reach zero: " + result);

        sc.close();
    }
}
