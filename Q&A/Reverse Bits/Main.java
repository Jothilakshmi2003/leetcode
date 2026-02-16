class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>>= 1;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int n = 43261596; // Example input
        int result = sol.reverseBits(n);

        System.out.println("Original: " + n);
        System.out.println("Reversed Bits Result: " + result);
    }
}
