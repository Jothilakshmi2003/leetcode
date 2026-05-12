import java.util.*;

class Solution {

    public int minimumEffort(int[][] tasks) {

        // Sort by (minimum - actual) in descending order
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        long ans = 0;
        long energy = 0;

        for (int i = 0; i < tasks.length; i++) {

            int actual = tasks[i][0];
            int minimum = tasks[i][1];

            // Increase initial energy if needed
            if (energy < minimum) {

                ans += (minimum - energy);
                energy = minimum;
            }

            // Perform task
            energy -= actual;
        }

        return (int) ans;
    }

    // Helper method to print tasks
    public static void printTasks(int[][] tasks) {

        for (int[] task : tasks) {
            System.out.println(task[0] + " " + task[1]);
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();

        int[][] tasks = new int[n][2];

        System.out.println("Enter actual and minimum energy for each task:");

        for (int i = 0; i < n; i++) {

            tasks[i][0] = sc.nextInt(); // actual
            tasks[i][1] = sc.nextInt(); // minimum
        }

        Solution obj = new Solution();

        int result = obj.minimumEffort(tasks);

        System.out.println("Minimum initial energy required: " + result);

        sc.close();
    }
}