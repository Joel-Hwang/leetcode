package Hard;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _493_ReversePairs {
    public int reversePairs(int[] nums) {
        int res = 0;
        for(int i = 0; i<nums.length-1; i++){
            for(int j = i+1; j<nums.length; j++){
                if((long)nums[i]-nums[j]-nums[j] > 0 ) res++;
            }
        }   
        return res;
    }
   

    @Test
    public void test(){
        System.out.println(reversePairs(new int[]{1,3,2,3,1}));
    }
}
