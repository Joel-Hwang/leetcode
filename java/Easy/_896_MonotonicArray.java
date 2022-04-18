package Easy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _896_MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        boolean inc = false;
        boolean dec = false;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] < nums[i-1]) inc = true;
            else dec = true;

            if(inc && dec) return false;
        }

        return true;
    }

    @Test
    public void test(){
        assertFalse(isMonotonic(new int[]{1,3,2}));
        assertTrue(isMonotonic(new int[]{1,2,2,3}));
        assertTrue(isMonotonic(new int[]{6,5,4,4}));
    }
}
