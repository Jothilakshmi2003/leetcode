import java.util.*;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            // Check if current number matches any reversed previous number
            if (indexMap.containsKey(nums[j])) {
                minDistance = Math.min(minDistance, j - indexMap.get(nums[j]));
            }

            // Store reversed number with index
            int reversed = reverseDigits(nums[j]);
            indexMap.put(reversed, j);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int reverseDigits(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + (num % 10);
            num /= 10;
        }
        return reversed;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] nums = { 123, 321, 456, 654, 111 };

        int result = obj.minMirrorPairDistance(nums);

        System.out.println("Minimum Mirror Pair Distance: " + result);
    }
}
