package Easy;

import org.testng.annotations.Test;

public class _231_PowerOfTwo{
    public boolean isPowerOfTwo(int n) {
        double res = Math.log(n)/Math.log(2);
        return Math.abs(res-(int)res) < 0.00000000000001 ;
    }


    @Test
    public void test(){
        System.out.println(isPowerOfTwo(268435457));
        System.out.println(isPowerOfTwo(17));
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(536870912));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(3));

    }
}