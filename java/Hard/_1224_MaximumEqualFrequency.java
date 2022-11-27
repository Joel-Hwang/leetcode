package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.testng.annotations.Test;

public class _1224_MaximumEqualFrequency {
    public int maxEqualFreq(int[] A) {
        int res = 0;

        Map<Integer, Integer> cntMap = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i<A.length; i++){
            cntMap.put(A[i], cntMap.getOrDefault(A[i], 0)+1);
            int freq = cntMap.get(A[i]);
            freqMap.put(freq, freqMap.getOrDefault(freq, 0) + 1);

            //다음걸 더할지 중간에걸 뺄지 결정
            int cnt = freq*freqMap.get(freq);
            if( cnt-1 == i && i != A.length-1 )
                res = Math.max(res, i+2);
            else if( cnt == i )
                res = Math.max(res, i+1);
        }

        return res;
    }


    /*
  1,1,2,2
        
  freq
  2: 2
  cnt
  1:2
  2:2
    */

   /* public int maxEqualFreq(int[] A) {
        
        int[] count = new int[100001], freq = new int[100001];
        int res = 0, N = A.length, a,c,d;
        for (int n = 1; n <= N; ++n) {
            a = A[n - 1];
            --freq[count[a]];
            c = ++count[a];
            ++freq[count[a]];

            if (freq[c] * c == n && n < N)
                res = n + 1;
            d = n - freq[c] * c;
            if ((d == c + 1 || d == 1) && freq[d] == 1)
                res = n;
        }
        return res;
    }*/

    @Test
    public void test(){
        assertEquals(4, maxEqualFreq(new int[]{1,1,1,2,3,4,5,6,7}));  //7-2(entry size)
        assertEquals(5, maxEqualFreq(new int[]{1,1,1,2,2,2}));  //7-2(entry size)
        assertEquals(7, maxEqualFreq(new int[]{2,2,1,1,5,3,3,5})); //9-2 mine size
        assertEquals(13, maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5}));
        assertEquals(13, maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5,5,5})); //16-3 mine size
    }

    

}
