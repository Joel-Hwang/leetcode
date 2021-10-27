package Easy;

import org.testng.annotations.Test;

public class _191_Numberof1Bits{
    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 0; i<32; i++){
            res += n & 1;
            n >>=1;
        }
        
        return res;
    }

    @Test
    public void test(){
        System.out.println(hammingWeight(-3));
        System.out.println(hammingWeight(1));
        System.out.println(hammingWeight(2));
        System.out.println(hammingWeight(3));
        System.out.println(hammingWeight(4));
        System.out.println(hammingWeight(5));
    }
}