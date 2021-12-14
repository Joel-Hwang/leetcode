package Hard;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

public class _1622_FancySequence {
    class Fancy {

        ArrayList<int[]> opList;
        ArrayList<Integer> nums;
        ArrayList<Integer> history;
        HashMap<Integer, Integer> startMap;

        public Fancy() {
            opList = new ArrayList<>();
            nums = new ArrayList<>();
            history = new ArrayList<>();
            startMap= new HashMap<>();
        }

        public void append(int val) {
            nums.add(val);
            history.add(0);
            if(!startMap.containsKey(nums.size()-1))
                startMap.put(nums.size()-1, opList.size());
        }

        public void addAll(int inc) {
            opList.add(new int[]{1, inc});
        }

        public void multAll(int m) {
            opList.add(new int[]{2, m});
        }

        public int getIndex(int idx) {
            if (idx >= nums.size())
                return -1;

            int initVal = nums.get(idx);
            for (int i = Math.max(startMap.get(idx), history.get(idx)); i < opList.size(); i++) {
                int[] dt = opList.get(i);
                initVal = cal(dt[0], dt[1], initVal);
            }
            nums.set(idx, initVal);
            history.set(idx, opList.size());
            return initVal;
        }
        

        private int cal(int op, int number, long value) {
            if (op == 1) {
                long val = value + number;
                return (int) ((val) % (int) (1e9 + 7));
            }
            if (op == 2) {
                long val = value * number;
                return (int) ((val) % (int) (1e9 + 7));
            }
            return 0;
        }
    }
 /*
 
 class Fancy {
    private static final int MOD = 1000000007;
    private int[] values = new int[8];
    private long add = 0;                       //addend
    private long mult = 1;                      //multiplier
    private long r_mult = 1;                    //multiplicative inverse
    private int size = 0;                       //append times
    private static int[] INVERSES = cache();    //multiplicative inverse cache
    
    public void append(int val) {
        //To prevent negative numbers from appearing in the numerator, add MOD to val-add
        long result = (val - add + MOD) * r_mult % MOD;
        //Expand if the array is full
        if (size >= values.length)
            values = Arrays.copyOf(values, size + (size << 1));
        values[size++] = ((int) result);
    }
    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }
    public void multAll(int m) {
        mult = mult * m % MOD;
        add = add * m % MOD;
        //Update multiplicative inverse:
        //Multiplicative inverse element is multiplicative,so r_mult = r_mult * INVERSES[m] % MOD
        //According to the test, there m <= 100, so the multiplicative inverse element in the interval [0-100] can be stored in the table and used directly
        //If m is not limited, then r_mult = multiplicativeInverse(m, MOD) % MOD
        r_mult = r_mult * INVERSES[m] % MOD;
    }
    public int getIndex(int idx) {
        if (idx >= size) return -1;
        return (int) ((mult * values[idx] + add) % MOD);
    }
    // Calculate the inverse element
    // 1/a % p = a^(p-2) % p
    static int multiplicativeInverse(int x, int mod) {
        long y = 1, m = mod - 2, p = x;
        //Similar to the fast exponentiation operation, if the modulus is taken for each step of the judgment, it is a fast exponentiation modular operation.
        for (int i = 0; 1L << i < m; i++, p = p * p % mod)
            if ((m >> i & 1) == 1) y = y * p % mod;
        return (int) y;
    }
    static int[] cache() {
        INVERSES = new int[101];
        INVERSES[0] = 0;
        INVERSES[1] = 1;
        for (int i = 2; i < INVERSES.length; i++) 
            INVERSES[i] = multiplicativeInverse(i, MOD);
        return INVERSES;
    }
}
 
 */

    @Test
    public void test() {
        int j = 0;
        String[] cmd = { "Fancy", "append", "append", "getIndex", "append", "getIndex", "addAll", "append", "getIndex",
                "getIndex", "append", "append", "getIndex", "append", "getIndex", "append", "getIndex", "append",
                "getIndex", "multAll", "addAll", "getIndex", "append", "addAll", "getIndex", "multAll", "getIndex",
                "multAll", "addAll", "addAll", "append", "multAll", "append", "append", "append", "multAll", "getIndex",
                "multAll", "multAll", "multAll", "getIndex", "addAll", "append", "multAll", "addAll", "addAll",
                "multAll", "addAll", "addAll", "append", "append", "getIndex" };
        int[][] arg = { {}, { 12 }, { 8 }, { 1 }, { 12 }, { 0 }, { 12 }, { 8 }, { 2 }, { 2 }, { 4 }, { 13 }, { 4 },
                { 12 }, { 6 }, { 11 }, { 1 }, { 10 }, { 2 }, { 3 }, { 1 }, { 6 }, { 14 }, { 5 }, { 6 }, { 12 }, { 3 },
                { 12 }, { 15 }, { 6 }, { 7 }, { 8 }, { 13 }, { 15 }, { 15 }, { 10 }, { 9 }, { 12 }, { 12 }, { 9 },
                { 9 }, { 9 }, { 9 }, { 4 }, { 8 }, { 11 }, { 15 }, { 9 }, { 1 }, { 4 }, { 10 }, { 9 } };
        int[] res = { 8, 12, 24, 24, 4, 12, 20, 24, 37, 42, 360, 220560, 285845760, 150746316 };
        Fancy dt = null;
        for (int i = 0; i < cmd.length; i++) {
            if ("Fancy".equals(cmd[i])) {
                dt = new Fancy();
            } else if ("append".equals(cmd[i])) {
                dt.append(arg[i][0]);
            } else if ("addAll".equals(cmd[i])) {
                dt.addAll(arg[i][0]);
            } else if ("multAll".equals(cmd[i])) {
                dt.multAll(arg[i][0]);
            } else { // getIndex
                System.out.println(res[j++] + " : " + dt.getIndex(arg[i][0]));
            }
        }
    }
}
