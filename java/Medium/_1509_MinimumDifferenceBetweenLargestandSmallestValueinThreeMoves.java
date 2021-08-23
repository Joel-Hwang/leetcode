package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _1509_MinimumDifferenceBetweenLargestandSmallestValueinThreeMoves {
    public int minDifference(int[] nums) {
        if(nums.length<5) return 0;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        /*//앞에서 3개
        res = Math.min(res, nums[nums.length-1] - nums[3]);
        //앞2뒤1
        res = Math.min(res, nums[nums.length-2] - nums[2]);
        //앞1뒤2
        res = Math.min(res, nums[nums.length-3] - nums[1]);
        //뒤에서 3개
        res = Math.min(res, nums[nums.length-4] - nums[0]);
        */
        for(int i = 0; i < 4; i++){
            res = Math.min(res, nums[nums.length-(4-i)] - nums[i]);
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(minDifference(new int[]{5,3,2,4}));
        System.out.println(minDifference(new int[]{1,5,0,10,14}));
        System.out.println(minDifference(new int[]{6,6,0,1,1,4,6}));
        System.out.println(minDifference(new int[]{1,5,6,14,15}));
    }
}
