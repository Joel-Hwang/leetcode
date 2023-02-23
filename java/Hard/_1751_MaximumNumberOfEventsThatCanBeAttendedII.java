package Hard;

import java.util.Arrays;

import org.testng.annotations.Test;

import java.util.*;

public class _1751_MaximumNumberOfEventsThatCanBeAttendedII {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

        Map<String, Integer> cache = new HashMap<>();
        
        return dfs(events,0,0,k,0,cache);
    }

    private int dfs(int[][] events, int cur, int count, int k, int end, Map<String, Integer> cache){

        if(count == k || cur == events.length) return 0;
        
        String key = count+"_"+end;
        Integer val = cache.get(key);
        if(val != null) return val;

        int max = dfs(events, cur+1, count, k, end, cache);
        if(events[cur][0] > end)
            max = Math.max(max, dfs(events, cur+1, count+1, k, events[cur][1], cache) + events[cur][2]);
    
        cache.put(key, max);
        return max;
    }






    public int maxValue2(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        int[] prev = new int[n];
        for (int i = 0; i < n; i++) prev[i] = binarySearsh(events, events[i][0]);

        int[][] dp = new int[n+1][k+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j+1]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[prev[i] + 1][j] + events[i][2]);
            }
        }

        return dp[n][k];
    }

    private int binarySearsh(int[][] a, int x) {
        int l = -1, r = a.length;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (a[m][1] < x) l = m;
            else r = m;
        }
        return l;
    }


    public int maxValue3(int[][] events, int k) {
        Arrays.sort(events,(o1,o2)-> Integer.compare(o1[1], o2[1]));

        int[] pre = new int[events.length];
        for(int i = 0; i<pre.length; i++) pre[i] = binarySearsh(events, events[i][0]);

        int[][] dp = new int[events.length+1][k+1];
        for(int i = 0; i<events.length; i++){
            for(int j = 0; j<k; j++){
                dp[i+1][j+1] = Math.max(dp[i+1][j+1],dp[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1],dp[i][j+1]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1],dp[pre[i]+1][j]+events[i][2]);
            }
        }

        return dp[events.length][k];
    }

    @Test
    public void test(){
        System.out.println(maxValue2(new int[][]{{1,2,4},{3,4,3},{2,3,1}}, 2));
    }
}
