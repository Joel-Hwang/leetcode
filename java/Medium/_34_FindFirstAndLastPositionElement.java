package Medium;

import java.util.Arrays;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
Follow up: Could you write an algorithm with O(log n) runtime complexity?

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
*/
public class _34_FindFirstAndLastPositionElement {
    public _34_FindFirstAndLastPositionElement(){
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},8)));
        System.out.println(Arrays.toString(searchRange(new int[]{},8)));
        
    }

    public int[] searchRange(int[] nums, int target) {
        int m=0,l = 0, r = nums.length-1;
        boolean isFound = false;
        while(l<=r){
            m = (l+r)/2;
            if(nums[m] == target) {isFound = true; break; }
            else if(nums[m] > target){
                r = m-1;
            }else{
                l = m+1;
            }
        }

        if(!isFound )return new int[]{-1,-1};

        int start=0,end=0;
        for(int i = m, j=m; i<nums.length || j>=0; i++,j--){
            if(i<nums.length && nums[i] == nums[m]) end = i;  
            if(j>=0 && nums[j] == nums[m]) start = j;  
        }
        return new int[]{start,end};
        
    }
}
