package Easy;
/*

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:

Input: nums = [1,3,5,6], target = 0
Output: 0
Example 5:

Input: nums = [1], target = 0
Output: 0
 

*/
public class _35_Search_Insert_Position {
    public _35_Search_Insert_Position(){
        System.out.println(searchInsert(new int[]{1,3,5,6},5));
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
        System.out.println(searchInsert(new int[]{1,3,5,6},7));
        System.out.println(searchInsert(new int[]{1,3,5,6},0));
        System.out.println(searchInsert(new int[]{1},0));
    }

    public int searchInsert(int[] nums, int target) {

        int l = 0, r = nums.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(nums[m] == target) return m;
            if(nums[m] < target){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return l;
    }
}
