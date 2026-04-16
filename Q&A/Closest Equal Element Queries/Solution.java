import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        // store indices
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int q : queries) {
            List<Integer> v = map.get(nums[q]);

            // only one time present
            if (v.size() == 1) {
                ans.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(v, q);
            int res = Integer.MAX_VALUE;

            // left neighbor
            int left = v.get((pos - 1 + v.size()) % v.size());
            int d1 = Math.abs(q - left);
            res = Math.min(res, Math.min(d1, n - d1));

            // right neighbor
            int right = v.get((pos + 1) % v.size());
            int d2 = Math.abs(q - right);
            res = Math.min(res, Math.min(d2, n - d2));

            ans.add(res);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] nums = { 1, 3, 1, 4, 1, 3 };
        int[] queries = { 0, 1, 2, 3, 4 };

        List<Integer> result = obj.solveQueries(nums, queries);

        System.out.println("Output: " + result);
    }
}
