package Medium;

import org.testng.annotations.Test;

public class _198_HouseRobber{
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for(int i = 2; i<dp.length; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        return dp[dp.length-1];
    }

    @Test
    public void test(){
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}