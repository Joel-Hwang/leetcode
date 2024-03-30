package Easy;

import java.util.*;

import org.testng.annotations.Test;
public class _1984_MinimumDifferenceBetweenHighestandLowestofKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = nums[nums.length-1];
        for(int i = 0; i<nums.length+1-k; i++)
            res = Math.min(res, nums[i-1+k]-nums[i]);
        return res;
    }

    @Test
    public void test(){
        minimumDifference(new int[]{8216,18083,81861,92320,30808,4467,36436,7960}, 8);
    }
}
