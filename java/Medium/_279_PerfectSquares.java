package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _279_PerfectSquares{
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i<=n; i++){
            for(int j = 1; j*j<=i; j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(numSquares(11));
        System.out.println(numSquares(2));
        System.out.println(numSquares(3));
        System.out.println(numSquares(4));
        System.out.println(numSquares(5));
        System.out.println(numSquares(6));
        System.out.println(numSquares(7));
        System.out.println(numSquares(8));
        System.out.println(numSquares(9));
    }
}