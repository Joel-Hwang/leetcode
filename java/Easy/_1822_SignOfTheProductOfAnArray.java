package Easy;

import org.testng.annotations.Test;

public class _1822_SignOfTheProductOfAnArray {
    public int arraySign(int[] nums){
        int result = 1;
        for(int num : nums){
            if(num == 0) return 0;
            if(num < 0) result *= -1;
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(arraySign(new int[]{-1,-2,-3,-4,3,2,1}));
    }
}
