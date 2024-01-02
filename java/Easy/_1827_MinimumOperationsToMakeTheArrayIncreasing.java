package Easy;

public class _1827_MinimumOperationsToMakeTheArrayIncreasing {
    public int minOperations(int[] nums) {
        int res = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i-1] < nums[i]) continue;
            res += nums[i-1]+1 - nums[i];
            nums[i] = nums[i-1]+1;
        }
        return res;
    }
}
