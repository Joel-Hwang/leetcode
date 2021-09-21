package Easy;

import org.testng.annotations.Test;

public class _485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = nums[0]==1?1:0;
        int res = cur;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == 1 ){
                cur++;
                res = Math.max(res,cur);
            }else{
                cur = 0;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1,1,0,1}));
    }
}
