package Hard;

import java.util.Arrays;

public class _164_MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
}
