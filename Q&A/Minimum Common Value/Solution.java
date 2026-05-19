public class Solution {

import java.util.*;

class Solution {

    public int getCommon(int[] nums1, int[] nums2) {

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {
                return nums2[j];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return -1;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input first array
        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();

        int[] nums1 = new int[n1];

        System.out.println("Enter elements of first sorted array:");

        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }

        // Input second array
        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();

        int[] nums2 = new int[n2];

        System.out.println("Enter elements of second sorted array:");

        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        int result = obj.getCommon(nums1, nums2);

        System.out.println("Smallest common element: " + result);

        sc.close();
    }
}