package Hard;

import java.math.BigInteger;

import org.testng.annotations.Test;

public class _793_PreimageSizeOfFactorialZeroesFunction{
    public int preimageSizeFZF(int k) {
        long l = 0, r = (long)Math.pow(10, 10);
        while(l<=r){
            long mid = (l+r)/2;
            long val = mid;
            long zeroCnt = 0;
            while(val !=0 ){
                val/=5;
                zeroCnt += val;
            }
            if(zeroCnt == k) return 5;
            else if(zeroCnt < k){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return 0;
    }

    @Test
    public void test(){
        preimageSizeFZF(0);
    }
}