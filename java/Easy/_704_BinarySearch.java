package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _704_BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target)
                l = mid+1;
            else
                r = mid-1;
        }
        return -1;
    }

    @Test
    public void test(){
        assertEquals(4, search(new int[]{-1,0,3,5,9,12}, 9));
        assertEquals(-1, search(new int[]{-1,0,3,5,9,12}, 2));
    }
}
