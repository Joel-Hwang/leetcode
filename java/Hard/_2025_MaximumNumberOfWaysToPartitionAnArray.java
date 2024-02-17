package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class _2025_MaximumNumberOfWaysToPartitionAnArray {
    public int waysToPartition(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int res = setDifferenceMap(nums,map);
        for(int i = 0; i<nums.length; i++){
            int gap = k-nums[i];
            List<Integer> afterChanged = map.getOrDefault(gap, new ArrayList<>());
            int curRes = 0;
            boolean hasMe = false;
            for(int j = 0; j<afterChanged.size(); j++){
                if(afterChanged.get(j)>i) curRes++;
                if(afterChanged.get(j) == i) hasMe = true;
            }

            afterChanged = map.getOrDefault(-gap, new ArrayList<>());
            for(int j = 0; j<afterChanged.size(); j++){
                if(afterChanged.get(j)<i) curRes++;
                if(afterChanged.get(j) == i) hasMe = true;
            }

            if(hasMe) curRes++;
            res = Math.max(res,curRes);
        }
        
        return res;
    }

    private int getSum(int[] nums){
        int sum = 0;
        for(int n : nums) sum+= n;
        return sum; 
    }

    private int setDifferenceMap(int[] nums, Map<Integer, List<Integer>> map){
        int sum = getSum(nums);
        int leftSum = 0;
        int rightSum = sum;
        int res = 0;
        for(int i = 0; i<nums.length-1; i++){
            leftSum += nums[i];
            rightSum -= nums[i];
            if(leftSum == rightSum) res++;
            List<Integer> list = map.getOrDefault(rightSum-leftSum, new ArrayList<>());
            list.add(i);
            map.put(rightSum-leftSum, list);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(waysToPartition(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,30827,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 0));
        System.out.println(waysToPartition(new int[]{2,-1,2}, 3));
        System.out.println(waysToPartition(new int[]{0,0,0}, 1));
        System.out.println(waysToPartition(new int[]{22,4,-25,-20,-15,15,-16,7,19,-10,0,-13,-14}, -33));
    }

    
}
