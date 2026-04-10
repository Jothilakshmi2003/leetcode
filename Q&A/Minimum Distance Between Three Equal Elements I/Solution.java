import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return -1;

        Map<Integer, List<Integer>> map = new HashMap<>();

        // store indices of each number
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        // check only consecutive triplets
        for (List<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i <= list.size() - 3; i++) {
                    int first = list.get(i);
                    int third = list.get(i + 2);
                    ans = Math.min(ans, 2 * (third - first));
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
