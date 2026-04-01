import java.util.*;

public class Solution {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++)
            idx[i] = i;

        // sort by position
        Arrays.sort(idx, (a, b) -> positions[a] - positions[b]);

        Stack<Integer> st = new Stack<>();

        for (int id : idx) {
            if (directions.charAt(id) == 'R') {
                st.push(id);
            } else {
                // L robot
                while (!st.isEmpty() && directions.charAt(st.peek()) == 'R' && healths[id] > 0) {
                    int top = st.peek();

                    if (healths[top] < healths[id]) {
                        st.pop();
                        healths[id]--;
                    } else if (healths[top] > healths[id]) {
                        healths[top]--;
                        healths[id] = 0;
                    } else {
                        st.pop();
                        healths[id] = 0;
                    }
                }

                if (healths[id] > 0) {
                    st.push(id);
                }
            }
        }

        // collect survivors
        List<int[]> survivors = new ArrayList<>();
        while (!st.isEmpty()) {
            int id = st.pop();
            survivors.add(new int[] { id, healths[id] });
        }

        // sort by original index
        Collections.sort(survivors, (a, b) -> a[0] - b[0]);

        List<Integer> ans = new ArrayList<>();
        for (int[] p : survivors) {
            ans.add(p[1]);
        }

        return ans;
    }

    // Main method for VS Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter number of robots: ");
        int n = sc.nextInt();

        int[] positions = new int[n];
        int[] healths = new int[n];

        System.out.println("Enter positions:");
        for (int i = 0; i < n; i++) {
            positions[i] = sc.nextInt();
        }

        System.out.println("Enter healths:");
        for (int i = 0; i < n; i++) {
            healths[i] = sc.nextInt();
        }

        System.out.print("Enter directions (string of L/R): ");
        String directions = sc.next();

        List<Integer> result = sol.survivedRobotsHealths(positions, healths, directions);

        System.out.println("Surviving robots' healths: " + result);

        sc.close();
    }
}
