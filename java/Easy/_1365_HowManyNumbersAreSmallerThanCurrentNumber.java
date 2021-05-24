package Easy;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.testng.annotations.Test;


public class _1365_HowManyNumbersAreSmallerThanCurrentNumber {
   
    public _1365_HowManyNumbersAreSmallerThanCurrentNumber(){
        
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        int[] dic = new int[500];
        int[] cp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(cp);

        dic[cp[0]] = 0;
        for(int i = 1; i<cp.length; i++){
            if(cp[i] == cp[i-1]) continue;
            dic[cp[i]] = i;
        }
        
        for(int i = 0; i<nums.length; i++)
            res[i] = dic[nums[i]];
        return res;

    }

    @Test
    public void test(){
        int[] nums = {8,1,2,2,3};
       
        assertArrayEquals(new int[]{4,0,1,1,3}, smallerNumbersThanCurrent(nums));
    }

}
