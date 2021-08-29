package zContest;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _5854_MinimumDifferenceBetweenHighestandLowestofKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i = nums.length-1; i>= k-1; i--){
            res = Math.min(res, nums[i] - nums[i-k+1] );
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(minimumDifference(new int[]{90}, 1));
        System.out.println(minimumDifference(new int[]{9,4,1,7}, 2));
    }
}
