import java.util.*;

class Solution {

    public int minimumCost(int[] cost) {

        Arrays.sort(cost);

        int total = 0;

        // Buy 2 most expensive candies, get 1 free
        for (int i = cost.length - 1; i >= 0; i -= 3) {

            total += cost[i];

            if (i - 1 >= 0) {
                total += cost[i - 1];
            }
        }

        return total;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candies: ");
        int n = sc.nextInt();

        int[] cost = new int[n];

        System.out.println("Enter candy costs:");

        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        int result = obj.minimumCost(cost);

        System.out.println("Minimum total cost: " + result);

        sc.close();
    }
}