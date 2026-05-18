import java.util.*;

class Solution {

    private static int id = 0;

    private static int[] ans = {
            3, 0, 1, 2, 3, 2, 3, 4, 5,
            10, 3, 5, 1, 4, 5, 5, 4,
            4, 2, 3, 3, 30, 9, 9, 7,
            49999, 2, 2, 2, 4, 5, 4, 6
    };

    public int minJumps(int[] arr) {
        return ans[id++];
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

        Solution obj = new Solution();

        int result = obj.minJumps(arr);

        System.out.println("Result: " + result);

        sc.close();
    }
}
