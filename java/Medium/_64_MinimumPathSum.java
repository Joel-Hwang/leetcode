package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];
        for(int i = 1; i<dp.length; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0]; 
        }
        for(int i = 1; i<dp[0].length; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i]; 
        }

        for(int i = 1; i<dp.length; i++)
            for(int j = 1; j<dp[i].length; j++)
                dp[i][j] = Math.min(grid[i][j]+dp[i-1][j], grid[i][j]+dp[i][j-1]);

        return dp[dp.length-1][dp[0].length-1];
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j != 0) grid[i][j] += grid[i][j-1];
                if(i != 0 && j == 0) grid[i][j] += grid[i-1][j];
                if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
    
    @Test
    public void test(){
        assertEquals(7, minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        assertEquals(12, minPathSum(new int[][]{{1,2,3},{4,5,6}}));
    }
}
