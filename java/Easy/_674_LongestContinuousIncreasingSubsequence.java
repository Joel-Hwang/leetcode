package Easy;

import org.testng.annotations.Test;

public class _674_LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        int cur = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i]>nums[i-1]) cur++;
            else{
                res = Math.max(res, cur);
                cur = 1;
            }
        }
        res = Math.max(res,cur);

        return res;
    }

    @Test
    public void test(){
        System.out.println(findLengthOfLCIS(new int[]{1,2,5,9,7}));
    }
}
