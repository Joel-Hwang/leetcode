package Medium;


public class _81_SearchInRotatedSortedArray2 {
    
public boolean search(int[] nums, int target) {
    int start = 0, end = nums.length-1, mid = -1;
    while(start <= end){
        mid = (start+end)/2;
        if(nums[mid] == target) return true;
        //left is sorted
        if(nums[start] < nums[mid]){
            if(target < nums[start] || target > nums[mid]){
                //target is in unsorted area;
                start = mid+1;
            }else{ //target is in sorted area;
                end = mid - 1;
            }
        } else if(nums[start] > nums[mid]){
            //right part is sorted.
            if(target < nums[mid] || target > nums[end]){
                //target is in unsorted area;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }else{
            start ++;
        }
    }
    return false;
}
    
    public boolean search2(int[] nums, int target) {
        for(int n : nums)
            if(n == target) return true;
        return false;
    }
}
