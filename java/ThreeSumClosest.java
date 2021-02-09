import java.util.Arrays;

class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int diff = nums[0] +  nums[1] +  nums[2];
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length-2;i++ ){
            int l = i+1, r=nums.length-1;
            while(l<r){
                int curSum = nums[l]+nums[r]+nums[i];
                if(curSum < target){
                    if( Math.abs(curSum - target) < Math.abs(diff-target) ){
                        diff = curSum;
                    }
                    l++;
                }else if(curSum > target){
                    if( Math.abs(curSum - target) < Math.abs(diff-target) ){
                        diff = curSum;
                    }
                    r--;
                }else{
                    return curSum;
                }
            }
        }
       return diff;
    }
                          
}