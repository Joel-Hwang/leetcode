package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _1641_CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        if (n==1) return 5;
        int[][] dp = new int[n][5];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 1;
        dp[0][4] = 1;

        for(int i = 1; i<n; i++) {
            dp[i][4] = dp[i-1][4];
            for(int j = 3; j>=0; j--) {
                dp[i][j] = dp[i][j+1] + dp[i-1][j];
            }
        }
        return dp[n-1][0]+dp[n-1][1]+dp[n-1][2]+dp[n-1][3]+dp[n-1][4];
    }

    @Test
    public void test(){
        //assertEquals(5, countVowelStrings(1));
        assertEquals(15, countVowelStrings(2));
        assertEquals(35, countVowelStrings(3));
        assertEquals(70, countVowelStrings(4));
    }
}
