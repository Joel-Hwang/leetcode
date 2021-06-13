package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _45_JumpGame2 {
    public int jump(int[] nums) {
        int res = 0;
        int i = 0;
        while(i<nums.length-1){
            int max = nums[i];
            int iMax = i;
            res++;
            if(i+nums[i] >= nums.length-1 ) return res;
            for(int j = i+1; j<=(i+nums[i]) && j<nums.length; j++){
                if(nums[j]+j>max+iMax){
                    max = nums[j];
                    iMax = j;
                }
            }
            i = iMax; //calculate i++ in first loop
        }
        return res;
    }

    //dp
    public int jump2(int[] nums) {
        //dp using bottom up 
        //dp state transiiton is 0(n) ,as we need to visit all the j for whcih jump can be made
        //j+nums[j] >= i...and for all such j we need to find the min
        //dp[i] = foreach j such that j+nums[j] >= i....dp[i] = Math.min(dp[i], 1+dp[j))
        //ie the cost to reach j + 1 cost for a jump from j to i
        int infi = Integer.MAX_VALUE/2;
        if(nums == null || nums.length ==0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++){
            dp[i] = infi;
            for (int j = i-1; j >= 0; j--){
                if(j + nums[j] >= i){
                    dp[i] = Math.min(dp[i], 1+ dp[j]);
                }
            }
        }
        return dp[nums.length-1];
    }

    @Test
    public void test(){
        assertEquals(1, jump(new int[]{3,2,1}));
        assertEquals(2, jump(new int[]{2,3,1,1,4}));
        assertEquals(2, jump(new int[]{2,3,0,1,4}));
        assertEquals(0, jump(new int[]{0}));
        assertEquals(0, jump(new int[]{1}));
        assertEquals(1, jump(new int[]{1,0}));
    }
}
