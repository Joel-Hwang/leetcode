package Medium;

import org.testng.annotations.Test;

public class _209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            if(sum >= target){
                while(sum >= target){
                    res = Math.min(res, i-l+1);
                    sum -= nums[l++];
                } 
            }
        }

        return res == Integer.MAX_VALUE?0:res;
    }


    @Test
    public void test(){
        int len = minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 });
        System.out.println(len);
    }
}
