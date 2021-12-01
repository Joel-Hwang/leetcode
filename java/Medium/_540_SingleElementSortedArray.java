package Medium;

import org.testng.annotations.Test;

public class _540_SingleElementSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int l=0,r=nums.length-1;

        while(l<=r){
            int m = (l+r)/2;
            if(getStartIdx(nums, m) == -1) return nums[m];
            else if(getStartIdx(nums, m)%2==0){
                l = getStartIdx(nums, m)+2;
            }else{
                r = getStartIdx(nums, m);
            }
        }
        return nums[l];
    }

    private int getStartIdx(int[] nums, int i){
        if(i == 0) return -1;
        if(i > 0 && nums[i] == nums[i-1]) return i-1;
        if(i<nums.length-1 && nums[i] == nums[i+1]) return i;
        return -1;
    }

    @Test
    public void test(){
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(singleNonDuplicate(new int[]{1,2,2,3,3,4,4,8,8}));
        System.out.println(singleNonDuplicate(new int[]{1,1,2,2,3,3,4,4,8}));
    }
}
