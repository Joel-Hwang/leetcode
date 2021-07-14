package Hard;

import org.testng.annotations.Test;

public class _72_EditDistance{
    
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp = new int[w1.length+1][w2.length+1];

        for(int i = 0; i<dp.length; i++) dp[i][0] = i;
        for(int i = 0; i<dp[0].length; i++) dp[0][i] = i;

        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                if(w1[i-1] == w2[j-1]) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
            }
        }
        return dp[w1.length][w2.length];
    }

    @Test
    public void test(){
        System.out.println(minDistance("intention", "execution"));
    }
}