package Hard;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.PriorityQueue;

import org.testng.annotations.Test;

public class _786_KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] A, int k){
        int[] res = new int[2];
        int n = A.length;
        if(n < 2) return new int[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, (a,b)->( A[a[0]]*A[b[1]] - A[b[0]]*A[a[1]] )  );
        for(int i = 0; i<n-1; i++){
            pq.add(new int[]{i,n-1});
        }
        while(--k>0 && !pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[1] - 1 > cur[0]){
                cur[1]--;
                pq.add(cur);
            }
        }
        res[0] = A[pq.peek()[0]];
        res[1] = A[pq.peek()[1]];
        return res;
    }

    @Test
    public void test(){
        int[] res = kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3);
        assertArrayEquals(new int[]{2,5}, res);
    }
}
