import java.util.*;

public class Solution {

    public int[] sortByBits(int[] arr) {
        TreeMap<Integer, PriorityQueue<Integer>> bitmap = new TreeMap<>();

        for (int val : arr) {
            int bits = Integer.bitCount(val);
            bitmap.putIfAbsent(bits, new PriorityQueue<>());
            bitmap.get(bits).add(val);
        }

        int[] ans = new int[arr.length];
        int index = 0;

        for (int key : bitmap.keySet()) {
            PriorityQueue<Integer> pq = bitmap.get(key);
            while (!pq.isEmpty()) {
                ans[index++] = pq.poll();
            }
        }

        return ans;
    }

    // Main method for VS Code
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

        int[] result = sol.sortByBits(arr);

        System.out.println("Sorted by number of set bits:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
