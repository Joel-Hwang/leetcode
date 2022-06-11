package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class _1658_MinimumOperationsToReduceXtoZero {
    public int minOperations(int[] nums, int x) {
        int res = 100001;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        int leftSum = 0, rightSum = 0;
        for(int i = 0; i<nums.length; i++){
            leftSum += nums[i];
            left.put(leftSum, i+1);
            rightSum += nums[nums.length-1-i];
            right.put(rightSum, i+1);
        }   
        if(left.containsKey(x)) res = Math.min(res,left.get(x));
        if(right.containsKey(x)) res = Math.min(res,right.get(x));

        for(int leftKey : left.keySet()){
            int rightKey = x-leftKey;
            if(right.containsKey(rightKey) && right.get(rightKey) + left.get(leftKey) <= nums.length){
                res = Math.min(res, right.get(rightKey) + left.get(leftKey));
            }
        }
        return res==100001?-1:res;
    }

    public int minOperations2(int[] nums, int x) {
        int target = -x;
        for(int num: nums) target += num;
        if(target == 0) return nums.length;
        if(target < 0) return -1;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, L = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            L = Math.max(L, i - map.getOrDefault(sum - target, i));
            map.put(sum, i);
        }
        return L > 0 ? nums.length - L : -1;
    }

    @Test
    public void test(){
        assertEquals(-1, minOperations(new int[]{1,1}, 3));
        assertEquals(2, minOperations(new int[]{1,1,4,2,3}, 5));
        assertEquals(1, minOperations(new int[]{5,2,3,1,1}, 1));
    }
}
