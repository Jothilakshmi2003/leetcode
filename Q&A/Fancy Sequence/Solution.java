import java.util.*;

class Fancy {
    private static final int MOD = 1000000007;
    private ArrayList<Long> val;
    private long a, b;

    public Fancy() {
        val = new ArrayList<>();
        a = 1;
        b = 0;
    }

    private long modPow(long x, long y, long mod) {
        long res = 1;
        x = x % mod;
        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % mod;
            }
            y = y / 2;
            x = (x * x) % mod;
        }
        return res;
    }

    public void append(int val) {
        long x = (val - b + MOD) % MOD;
        this.val.add((x * modPow(a, MOD - 2, MOD)) % MOD);
    }

    public void addAll(int inc) {
        b = (b + inc) % MOD;
    }

    public void multAll(int m) {
        a = (a * m) % MOD;
        b = (b * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= val.size())
            return -1;
        return (int) ((a * val.get(idx) + b) % MOD);
    }
}

public class Solution {
    public static void main(String[] args) {
        Fancy obj = new Fancy();

        obj.append(2); // [2]
        obj.addAll(3); // [5]
        obj.append(7); // [5,7]
        obj.multAll(2); // [10,14]

        System.out.println(obj.getIndex(0)); // 10
        obj.addAll(3); // [13,17]
        obj.append(10); // [13,17,10]

        System.out.println(obj.getIndex(0)); // 13
        System.out.println(obj.getIndex(1)); // 17
        System.out.println(obj.getIndex(2)); // 10
    }
}
