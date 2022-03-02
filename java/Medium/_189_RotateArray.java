package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _189_RotateArray {
    public void rotate(int[] nums, int k) {
        int[] copy = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            copy[i] = nums[i];
        }

        for(int i = 0; i<nums.length; i++){
            int newIdx = (k+i)%nums.length;
            nums[newIdx] = copy[i];
        }
    }

    @Test
    public void test(){
        int[] test = {-1,-100,3,99};
        rotate(test, 2);
        System.out.println(Arrays.toString(test));
    }
}
