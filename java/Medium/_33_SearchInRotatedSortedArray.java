package Medium;
/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
*/
public class _33_SearchInRotatedSortedArray{
    public _33_SearchInRotatedSortedArray(){

    }

    //for로 뒤져서 desc 되는 부분(k) 찾은 다음
    //배열을 K 기준으로 2개로 쪼개서 target이 있는 쪽만 binary Search
    public int search(int[] nums, int target) {
        return 0;
    }

}