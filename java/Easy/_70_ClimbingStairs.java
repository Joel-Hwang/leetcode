package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _70_ClimbingStairs {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i<n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }

    @Test
    public void test(){
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
    }
}
