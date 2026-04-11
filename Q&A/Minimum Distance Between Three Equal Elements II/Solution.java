import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!map.containsKey(num)) {
                map.put(num, new int[] { -1, -1 }); // last two positions
            }

            int[] pos = map.get(num);

            // shift positions
            pos[0] = pos[1];
            pos[1] = i;

            // if we have 3 occurrences
            if (pos[0] != -1) {
                ans = Math.min(ans, 2 * (i - pos[0]));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
