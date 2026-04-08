import java.util.*;

public class Solution {

    public int xorAfterQueries(int[] n, int[][] q) {
        int mod = 1_000_000_007;

        for (int[] a : q) {
            for (int i = a[0]; i <= a[1]; i += a[2]) {
                long p = (long) n[i] * a[3];
                n[i] = (int) (p % mod);
            }
        }

        int s = 0;
        for (int i : n)
            s ^= i;

        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();

        int[][] queries = new int[q][4];
        System.out.println("Enter queries (l r step multiplier):");
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 4; j++) {
                queries[i][j] = sc.nextInt();
            }
        }

        int result = sol.xorAfterQueries(arr, queries);
        System.out.println("Final XOR: " + result);

        sc.close();
    }
}
