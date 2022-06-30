package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _462_MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int median = nums[nums.length/2]; 
        for(int num : nums) {
            res += Math.abs(median-num); 
        }
        return res;
    }
    
    @Test
    public void test(){
        assertEquals(14, minMoves2(new int[]{1,0,0,8,6}));
        assertEquals(2, minMoves2(new int[]{1,2,3}));
        assertEquals(16, minMoves2(new int[]{1,10,2,9}));
    }
}
