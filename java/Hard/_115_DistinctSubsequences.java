package Hard;

import org.testng.annotations.Test;

public class _115_DistinctSubsequences {
    public int numDistinct(String S, String T) {
        // 이전까지는 ba가 1개 있었고 b는 3개 있었음. 이번에 a가 나왔으니까 원래 3개의 b랑 합쳐서 3개 더하기 이전까지 있었던 ba 1개
        // = 4
        int[][] dp = new int[T.length() + 1][S.length() + 1];
        for (int i = 0; i < dp[0].length; i++)
            dp[0][i] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = T.charAt(i-1) == S.charAt(j-1) ? dp[i - 1][j - 1] + dp[i][j - 1] : dp[i][j - 1];
            }
        }
        return dp[T.length()][S.length()];
    }

    @Test
    public void test() {
        System.out.println(numDistinct("aabbbgg", "bag"));
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));
    }
}
