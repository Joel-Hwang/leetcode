package Medium;

import org.testng.annotations.Test;

public class _50_PowXN {
    public double myPow(double x, int n) {
        if(x == 1) return x;
        if(x == -1) return (n%2==0?1:-1);
        double res = 1;
        if(n >=0 )
            for(int i = 0; i<n; i++)
                res *=x;
        else
            for(int i = n; i<0; i++){
                res /=x;
                if(res == 0 ) return 0;
            }
        return res;
    }

    @Test
    public void test(){
        myPow(2, -2147483648);
    }
}