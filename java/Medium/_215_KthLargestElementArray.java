package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _215_KthLargestElementArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    @Test
    public void test(){
        assertEquals(5, findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
