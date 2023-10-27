package Hard;

import org.testng.annotations.Test;

public class _1643_KthSmallestInstructions {
    public String kthSmallestPath(int[] destination, int k) {
        StringBuilder sb = new StringBuilder();
        int v = destination[0];
        int h = destination[1];
        while(h>0 && v>0){
            int countH = getCaseCount(v+h-1, h-1);
            if(countH >= k){
                sb.append("H");
                h-=1;
            }else{
                sb.append("V");
                v-=1;
                k -= countH;
            }
        }
        for(int i = 0; i<h; i++) sb.append("H");
        for(int i = 0; i<v; i++) sb.append("V");
        return sb.toString();
    }

    private int getCaseCount(int n, int r) {
        int result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(kthSmallestPath(new int[]{2,3}, 1));
        System.out.println(kthSmallestPath(new int[]{2,3}, 3));
        System.out.println(kthSmallestPath(new int[]{2,3}, 2));
    }
}
