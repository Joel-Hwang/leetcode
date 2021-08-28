package Medium;

import org.testng.annotations.Test;

public class _97_InterleavingString {
    //2 dimension DP
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int l = s3.length();
        if (n + m != l)
            return false;

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1))
                dp[i][0] = true;
        }

        for (int i = 1; i <= m; i++) {
            if (dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1))
                dp[0][i] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);
                if( (c1 == c3 && dp[i-1][j]) || (c2 == c3 && dp[i][j-1]) ) dp[i][j] = true;
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    @Test
    public void test(){
        System.out.println(isInterleave("abc", "def", "abcdef"));
        System.out.println(isInterleave("aabc", "dbbca", "aadbbcbcac"));
    }
}
