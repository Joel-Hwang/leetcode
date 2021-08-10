package Medium;

import org.testng.annotations.Test;

public class _162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if( nums.length == 1 || nums[0] > nums[1] ) return 0;
        for(int i = 1; i<nums.length-1; i++){
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1])
                return i;
        }
        return nums.length-1;
    }

    public int findPeakElement2(int[] nums){
        int l = 0, r = nums.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid] > nums[mid+1]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    @Test
    public void test(){
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElement(new int[]{1}));
        System.out.println(findPeakElement(new int[]{1,2}));
        System.out.println(findPeakElement(new int[]{2,1}));
    }
}
