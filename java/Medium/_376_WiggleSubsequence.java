package Medium;

public class _376_WiggleSubsequence{
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<2) return nums.length;

        int preDiff = nums[1] - nums[0];
        int res = preDiff==0?1:2;
        for(int i = 2; i<nums.length; i++){
            int diff = nums[i] - nums[i-1];
            if( (diff>0 && preDiff<=0) ||  (diff<0 && preDiff>=0 ) ){
                res++;
                preDiff = diff;
            }
        }
        return res;
    }
}