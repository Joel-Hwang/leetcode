package zContest;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _5832_ArrayWithElementsNotEqualAverageNeighbors {
    public int[] rearrangeArray(int[] nums) {
        for(int i = 1; i<nums.length-1; i++){
            if(nums[i-1] + nums[i+1] == nums[i]*2){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
                i = Math.max(0,i-2);
            }
        }
        return nums;
    }

    public boolean valid(int[] nums){
        for(int i = 1; i<nums.length-1; i++){
            if(nums[i-1] + nums[i+1] == nums[i]*2){
                System.out.println(i+ " : "+Arrays.toString(nums));
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        int[] t = new int[10000];
        for(int i=0;i<t.length; i++) t[i] = i;
        System.out.println(valid(rearrangeArray(t)));
       /* System.out.println(valid(rearrangeArray(new int[]{3,6,9})));
        System.out.println(valid(rearrangeArray(new int[]{0,1,2})));
        System.out.println(valid(rearrangeArray(new int[]{3,4,6,8})));
        System.out.println(valid(rearrangeArray(new int[]{1,6,8,12,34})));
        System.out.println(valid(rearrangeArray(new int[]{9,10,5,2,7,3})));*/

    }
}
