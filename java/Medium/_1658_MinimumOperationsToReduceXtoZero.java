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

    @Test
    public void test(){
        assertEquals(-1, minOperations(new int[]{1,1}, 3));
        assertEquals(2, minOperations(new int[]{1,1,4,2,3}, 5));
        assertEquals(1, minOperations(new int[]{5,2,3,1,1}, 1));
    }
}
