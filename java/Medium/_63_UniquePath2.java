package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _63_UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        boolean obsY = false, obsX = false;
        for (int i = 0; i < dp.length; i++) {
            if (obsY || obstacleGrid[i][0] == 1){
                dp[i][0] = -1;
                obsY = true;
            }else{
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            if (obsX || obstacleGrid[0][i] == 1){
                dp[0][i] = -1;
                obsX = true;
            }else{
                dp[0][i] = 1;
            }
        }

        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                if(dp[i][j] < 0 || obstacleGrid[i][j] == 1) dp[i][j] = -1;
                else if( dp[i-1][j] < 0 || obstacleGrid[i-1][j] == 1) dp[i][j] = dp[i][j-1];
                else if( dp[i][j-1] < 0 || obstacleGrid[i][j-1] == 1) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return Math.max(0,dp[dp.length - 1][dp[0].length - 1]);
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }

    @Test
    public void test(){
        assertEquals(2, uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        assertEquals(1, uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
    }
}
