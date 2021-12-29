package Easy;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _628_MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int res = nums[nums.length-1];
        if(res<0) return res*nums[nums.length-2]*nums[nums.length-3];

        res *= Math.max(nums[nums.length-2]*nums[nums.length-3],nums[0]*nums[1]);
        return res;
    }

    @Test
    public void test(){
        System.out.println(maximumProduct(new int[]{-1,-2,-3,-4}));
    }
}
