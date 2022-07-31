package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

import org.testng.annotations.Test;

public class _1326_MinimumNumberOfTapsToOpenToWaterAGarden {
    public int minTaps(int n, int[] ranges) {
        int[][] ranges2 = new int[ranges.length][2];
        for(int i = 0; i<ranges2.length; i++){
            ranges2[i][0] = Math.max(0,i-ranges[i]);
            ranges2[i][1] = Math.min(n,i+ranges[i]);
        }
        Arrays.sort(ranges2,(int[] a, int[] b)->{
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int res= 1;
        int max = ranges2[0][1];
        int curMax = max;
        int[] cur = ranges2[0];
        int nextCurIdx = 0;
        for(int i = 1; i<ranges2.length; i++){
            if(ranges2[i][0] > cur[1]){
                res++;
                if(cur == ranges2[nextCurIdx] ) return -1;
                cur = ranges2[nextCurIdx];
                max = curMax;
                
            }

            if(curMax < ranges2[i][1]){
                nextCurIdx = i;
                curMax = ranges2[i][1];
            }
            
        }

        if(cur != ranges2[nextCurIdx]){
            res++;
            max = curMax;
        }
        
        return max < n ? -1: res;
    }

    public int minTaps2(int n, int[] ranges) {
        Integer[] idx = IntStream.range(0, ranges.length).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, Comparator.comparingInt(o -> o-ranges[o]));
        int ans = 1, cur = 0, end = 0;
        for (int i = 0;i<ranges.length&&end<n;i++){
            int j = idx[i];
            if (j-ranges[j]>cur){
                cur=end;
                ans++;
            }
            if (j-ranges[j]<=cur){
                end=Math.max(end, j+ranges[j]);
            }
        }
        return end<n?-1:ans;
    }
    @Test
    public void test(){
        assertEquals(6, minTaps(35,new int[]{1,0,4,0,4,1,4,3,1,1,1,2,1,4,0,3,0,3,0,3,0,5,3,0,0,1,2,1,2,4,3,0,1,0,5,2}));
        assertEquals(-1, minTaps(3,new int[]{1,0,0,1}));
        assertEquals(2, minTaps(3,new int[]{1,0,0,2}));
        assertEquals(2, minTaps(3,new int[]{2,1,1,2}));
        assertEquals(-1, minTaps(3,new int[]{0,0,0,0}));
        assertEquals(1, minTaps(5,new int[]{3,4,1,1,0,0}));
    }
}
