package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _764_LargestPlusSign {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        for (int[] row : dp) {
            Arrays.fill(row, N);
        }
        for (int[] mine : mines) {
            dp[mine[0]][mine[1]] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0, l = 0; j < N; j++) {
                dp[i][j] = Math.min(dp[i][j], l = (dp[i][j] == 0 ? 0 : l + 1));
            }
            for (int k = N-1, r = 0; k >= 0; k--) {
                dp[i][k] = Math.min(dp[i][k], r = (dp[i][k] == 0 ? 0 : r + 1));
            }
            for (int j = 0, b = 0; j < N; j++) {
                dp[j][i] = Math.min(dp[j][i], b = (dp[j][i] == 0 ? 0 : b + 1));
            }
            
            for (int k = N-1, t = 0; k >= 0; k--) {
                dp[k][i] = Math.min(dp[k][i], t = (dp[k][i] == 0 ? 0 : t + 1));
            }
        }

        int res = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                res = Math.max(res,dp[i][j]);
            }
        }

        return res;
    }

    @Test
    public void test() {
        System.out.println(orderOfLargestPlusSign(5, new int[][] { { 3, 0 }, { 3, 3 } }));
        System.out.println(orderOfLargestPlusSign(2, new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } }));
        System.out.println(orderOfLargestPlusSign(2, new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 } }));
        System.out.println(orderOfLargestPlusSign(6, new int[][] { { 4, 2 } }));
        System.out.println(orderOfLargestPlusSign(5, new int[][] { { 4, 2 } }));
        System.out.println(orderOfLargestPlusSign(1, new int[][] { { 0, 0 } }));
    }
}
