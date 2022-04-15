package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _552_StudentAttendanceRecordII {
    public int checkRecord(int n) {
        long[] A = new long[n];
        long[] L = new long[n];
        long[] P = new long[n];
        long[] pureP = new long[n];
        long[] pureL = new long[n];
        if(n == 1) return 3;
        if(n == 2) return 8;

        A[0] = 1; L[0] = 1; P[0] = 1; pureP[0] = 1; pureL[0] = 1;
        A[1] = 2; L[1] = 3; P[1] = 3; pureP[1] = 2; pureL[1] = 2;

        for(int i = 2; i<n; i++){
            P[i] = (P[i-1] + L[i-1] + A[i-1])%1000000007;
            pureP[i] = (pureP[i-1] + pureL[i-1])%1000000007;
            pureL[i] = (pureP[i-1] + pureP[i-2])%1000000007;
            L[i] = (P[i-1]+A[i-1]+P[i-2]+A[i-2])%1000000007;
            A[i] = ( pureP[i-1] + pureL[i-1])%1000000007;
        }

        return (int)((A[n-1] + L[n-1] + P[n-1])%1000000007);
        
    }

    public int checkRecord2(int num) {
        long[][][] dp = new long[num + 1][3][4];
        long MOD = 1000000007;
        for(int n = 0; n <= num; n++){
            for(int absent = 2; absent >= 0; absent--) {
                for(int late = 3; late >= 0; late--){
                    if(absent == 2 || late == 3) 
                        dp[n][absent][late] = 0;
                    else if(n == 0) 
                        dp[n][absent][late] = 1;
                    else {
                        long p = dp[n-1][absent + 1][0] % MOD;
                        long l = dp[n-1][absent][late + 1] % MOD;
                        long a = dp[n-1][absent][0] % MOD;

                        dp[n][absent][late] = (p+l+a) % MOD;
                    }
                }
            }
        }
        
        return (int) dp[num][0][0];
    }

    @Test
    public void test(){
        assertEquals(checkRecord2(10101), checkRecord(10101));
        assertEquals(19, checkRecord(3));
        assertEquals(8, checkRecord(2));
        assertEquals(3, checkRecord(1));
    }
}
