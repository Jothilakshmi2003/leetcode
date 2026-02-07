class Solution {
    public int minimumDeletions(String s) {
        int res = 0;
        int count = 0; // number of 'b' seen so far

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                count++;
            } else if (count != 0) {
                res++;
                count--;
            }
        }

        return res;
    }
}

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        String s = "aababbab"; // test input

        int result = sol.minimumDeletions(s);

        System.out.println("Minimum deletions required: " + result);
    }
}
