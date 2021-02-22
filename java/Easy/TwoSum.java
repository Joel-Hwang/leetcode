package Easy;

import java.util.HashMap;

class TwoSum {

    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(hm.containsKey(target - nums[i])) return new int[]{i, hm.get(target-nums[i])};
            else hm.put(nums[i], i);
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target){
        for(int i = 0; i<nums.length-1; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target) return new int[]{i,j};
            }
        }
        return null;
    }
}