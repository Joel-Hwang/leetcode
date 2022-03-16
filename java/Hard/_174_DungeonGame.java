package Hard;

import org.testng.annotations.Test;

public class _174_DungeonGame {
    public int calculateMinimumHP(int[][] d) {
        int[][] dp = new int[d.length][d[0].length];
        dp[dp.length-1][dp[0].length-1] = d[d.length-1][d[0].length-1]>=0?1 : 1-d[d.length-1][d[0].length-1];
        
        for(int i = dp.length-2; i>=0; i--){
            dp[i][dp[0].length-1] = dp[i+1][dp[0].length-1]- d[i][d[0].length-1];
            if(dp[i][dp[0].length-1] <= 0) dp[i][dp[0].length-1] = 1;
        }

        for(int i = dp[0].length-2; i>=0; i--){
            dp[dp.length-1][i] = dp[dp.length-1][i+1] - d[d.length-1][i];
            if(dp[dp.length-1][i]<=0) dp[dp.length-1][i] = 1;

        }

            
        for(int i = dp.length-2; i>=0; i--){
            for(int j = dp[0].length-2; j>=0; j--){
                int minVal = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = minVal - d[i][j];
                if(dp[i][j] <= 0) dp[i][j] = 1;
            }
        }
        return dp[0][0];
    }

   

    @Test
    public void test(){
        System.out.println(calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
        System.out.println(calculateMinimumHP(new int[][]{{1,-3,3},{0,-2,0},{-3,-3,-3}}));
    }
}