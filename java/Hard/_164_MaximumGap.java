package Hard;

import java.util.Arrays;

public class _164_MaximumGap {
    public int maximumGap2(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        
            //get the max and min value of the array
            int min = nums[0];
            int max = nums[0];
            for(int i : nums){
                min = Math.min(min, i);
                max = Math.max(max, i);
            }

            //the minimum possible gap, ceiling of the integer division
            int gap = (int) Math.ceil((double)(max-min)/(nums.length-1));
            //store the min values in the buckets.
            int[] bucketsMin = new int[nums.length-1];
            //store the max values in the buckets.
            int[] bucketsMax = new int[nums.length-1];
            Arrays.fill(bucketsMin, Integer.MAX_VALUE);
            Arrays.fill(bucketsMax, Integer.MIN_VALUE);
            //put numbers into buckets
            for(int i:nums){
                if(i == min || i == max) continue;
                int idx = (i-min)/gap; //index of the right position in the buckets
                bucketsMin[idx] = Math.min(i,bucketsMin[idx]);
                bucketsMax[idx] = Math.max(i,bucketsMax[idx]);
            }

            //scan the buckets for the max gap
            int maxGap = Integer.MIN_VALUE;
            int previous = min;
            for(int i = 0; i<nums.length-1; i++){
                //empty buckets
                if(bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE) continue;
                //min value minus the previous value is the current gap
                maxGap = Math.max(maxGap,bucketsMin[i] - previous);
                previous = bucketsMax[i];
            }
            maxGap = Math.max(maxGap, max - previous);

        return maxGap;
    }
}
