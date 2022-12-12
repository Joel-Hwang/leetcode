package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _724_FindPivotIndex {
    public int pivotIndex(int[] nums){
        //presum all - paresum - left - index
        int totalSum = 0, leftSum = 0;
        
        for(int i = 0; i<nums.length; i++) totalSum += nums[i];
        for(int i = 0; i<nums.length; i++){
            if(leftSum == totalSum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        
        return -1;
    }

    @Test
    public void test(){
    assertEquals(3, pivotIndex(new int[]{1,7,3,6,5,6}));
    assertEquals(-1, pivotIndex(new int[]{1,2,3}));
    assertEquals(0, pivotIndex(new int[]{2,1,-1}));
    }
}
