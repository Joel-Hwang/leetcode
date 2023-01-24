package Medium;

import org.testng.annotations.Test;

public class _477_TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for(int i = 0; i<32; i++){
            int bitCount = 0;
            for(int n : nums){
                bitCount += (n>>i) & 1;
            }
            res += bitCount*(nums.length-bitCount);
        }

        return res;    
    }

    
    @Test
    public void test(){
        System.out.println(totalHammingDistance(new int[]{6,1,8,6,8}));
    }
}
