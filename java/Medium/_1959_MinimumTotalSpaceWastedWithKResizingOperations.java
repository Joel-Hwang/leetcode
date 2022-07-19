package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _1959_MinimumTotalSpaceWastedWithKResizingOperations {

    public int minSpaceWastedKResizing(int[] nums, int k) {
        Integer[][] memo = new Integer[200][200];
        return dp(nums,memo,0,k);
    }

    private int dp(int[] nums, Integer[][] memo, int i, int k){
        if( i == nums.length) return 0;
        if(k == -1) return 200000000;
        if(memo[i][k] != null) return memo[i][k];
        
        int sum = 0, max = nums[i];
        int ans = 200000000;
        for(int j = i; j<nums.length; j++){
            sum += nums[j];
            max = Math.max(max,nums[j]);
            int waste = max*(j-i+1) - sum;
            ans = Math.min(ans,waste + dp(nums,memo,j+1,k-1));
        }
        memo[i][k] = ans;
        return ans;
    }


    /*int n, INF = 200000000;
    Integer[][] memo = new Integer[200][200];
    public int minSpaceWastedKResizing(int[] nums, int k) {
        n = nums.length;
        return dp(nums,0,k);
    }

    private int dp(int[] nums, int i, int k){
        if(i == n) return 0;
        if(k == -1) return INF;
        if(memo[i][k] != null) return memo[i][k];
        int ans = INF, maxNum = nums[i], totalSum = 0;
        for(int j = i; j < n; j++){
            maxNum = Math.max(maxNum,nums[j]);
            totalSum += nums[j];
            int wasted = maxNum*(j-i+1)-totalSum;
            ans = Math.min(ans, dp(nums, j+1, k-1)+wasted);
        }
        memo[i][k] = ans;
        System.out.println(String.format("i:%d k:%d memo[i][k]:%d", i,k,memo[i][k]));
        return ans;
   }*/
   
   @Test
   public void test(){
       assertEquals(15, minSpaceWastedKResizing(new int[]{10,20,15,30,20}, 2));
   }
}
