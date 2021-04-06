package Easy;
/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
*/
public class _283_Move_Zeroes {
    public _283_Move_Zeroes(){
        moveZeroes(new int[]{0,1,0,3,12});
    }

    public void moveZeroes(int[] nums) {
        int curNonZero = -1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[++curNonZero];
                nums[curNonZero] = temp;
            }
        }
    }
}
