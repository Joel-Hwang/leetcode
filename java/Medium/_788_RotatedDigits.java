package Medium;

import org.testng.annotations.Test;

public class _788_RotatedDigits {
    public int rotatedDigits(int n) {
        int res = 0;
        for(int i = 1; i<=n; i++){
            if(hasGood(i)) res++;
        }
        return res;
    }

    private boolean hasGood(int n){
        int goodCnt = 0;

        while(n>0){
            int digit = n%10;
            if(digit == 3 || digit == 4 || digit == 7) return false;
            if(digit == 2 || digit == 5 || digit == 6 || digit == 9 ) goodCnt++;
            n /= 10;
        }
        return goodCnt>0;
    }

    @Test
    public void test(){
        System.out.println(rotatedDigits(857));
    }
}
