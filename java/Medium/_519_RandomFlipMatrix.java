package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.testng.annotations.Test;

public class _519_RandomFlipMatrix {
    class Solution {

        Map<Integer, Integer> map;
        int m,n,total;
        public Solution(int m, int n) {
           map = new HashMap<>();
           this.m = m;
           this.n = n;
           total = m*n;
        }
        
        public int[] flip() {
            int r = new Random().nextInt(total--);
            int x = map.getOrDefault(r, r);
            map.put(r, map.getOrDefault(total, total));
            return new int[]{x/n, x%n};
        }
        
        public void reset() {
            map.clear();
            total = m*n;
        }
    }

    @Test
    public void test(){
        Solution sol = new Solution(4, 17);
        sol.flip();
        sol.flip();
        sol.reset();
        sol.flip();
        sol.flip();
        sol.reset();
        sol.flip();
        sol.flip();
        sol.flip();
        sol.reset();
        sol.flip();
        sol.flip();
    }
}
