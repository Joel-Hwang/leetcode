package Hard;
import java.util.*;

import org.testng.annotations.Test;


public class _1388_PizzaWith3nSlices{
    public int maxSizeSlices(int[] slices) {
        int m = slices.length, n = m/3;
        int[] slices1 = Arrays.copyOfRange(slices, 0, m-1);
        int[] slices2 = Arrays.copyOfRange(slices, 1, m);
        return Math.max(maxSum(slices1,n), maxSum(slices2,n));
    }

    private int maxSum(int[] arr, int n){
        int m = arr.length;
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(i==1) dp[i][j]=arr[0];
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-2][j-1]+arr[i-1]);
                }        
            }
        }
        return dp[m][n];
    }

   

    @Test
    public void test(){
        System.out.println(maxSizeSlices(new int[]{1,2,3,4,5,6}));
        System.out.println(maxSizeSlices(new int[]{9,8,1,7,7,9,5,10,7,9,3,8,3,4,8}));
        System.out.println(maxSizeSlices(new int[]{8,9,8,6,10,1}));
    }
}
