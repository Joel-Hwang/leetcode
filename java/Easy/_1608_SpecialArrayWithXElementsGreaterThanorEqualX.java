package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _1608_SpecialArrayWithXElementsGreaterThanorEqualX {
    public int specialArray2(int[] nums) {
        Arrays.sort(nums);
        int[] preSum = new int[1001];
        for(int n : nums){
            for(int i = 0; i<=n; i++)
                preSum[i]++;
        }
        
        for(int i = 0; i < preSum.length; i++){
            if(i == preSum[i]) return i;
        }
        return -1;
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i<nums.length/2; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = temp;
        }

        if(nums[nums.length-1]>=nums.length) return nums.length;

        for(int i = nums.length-1; i >=1 ; i--){
            if(nums[i] >= (i+1) && (i+1) > nums[i+1]) return (i+1);
        }
        return -1;
    }


    @Test
    public void test(){
        assertEquals(-1,specialArray(new int[]{3,6,7,7,0}));
        assertEquals(2,specialArray(new int[]{3,5}));
    }
}
