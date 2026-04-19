import java.util.*;

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int maxDist = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                maxDist = Math.max(maxDist, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDist;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] nums1 = { 55, 30, 5, 4, 2 };
        int[] nums2 = { 100, 20, 10, 10, 5 };

        int result = obj.maxDistance(nums1, nums2);

        System.out.println("Maximum Distance: " + result);
    }
}