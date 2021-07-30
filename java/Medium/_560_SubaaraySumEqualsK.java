package Medium;

import java.util.HashMap;

import org.testng.annotations.Test;

public class _560_SubaaraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        // Edge cases
        if(nums.length == 0)    return 0;
        
        // Sliding window -- No, contains negative number
        // hashmap + preSum
        /*
            1. Hashmap<sum[0,i - 1], frequency>
            2. sum[i, j] = sum[0, j] - sum[0, i - 1]    --> sum[0, i - 1] = sum[0, j] - sum[i, j]
                   k           sum      hashmap-key     -->  hashmap-key  =  sum - k
            3. now, we have k and sum.  
                  As long as we can find a sum[0, i - 1], we then get a valid subarray
                 which is as long as we have the hashmap-key,  we then get a valid subarray
            4. Why don't map.put(sum[0, i - 1], 1) every time ?
                  if all numbers are positive, this is fine
                  if there exists negative number, there could be preSum frequency > 1
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        map.put(0, 1);
        for(int cur : nums) {
            sum += cur;
            if(map.containsKey(sum - k))  // there exist a key, that [hashmap-key  =  sum - k]
                result += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result; 
    }

    // Brutal force
    public int subarraySum2(int[] nums, int k) {
        int res = 0;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum = 0;
            for (int j = i; j < nums.length; j++) {
                curSum += nums[j];
                if (curSum == k)
                    res++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(subarraySum(new int[] { -1, -1, 1 }, -1));
        System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));
        System.out.println(subarraySum(new int[] { 1, 2, 3 }, 3));
    }
}
