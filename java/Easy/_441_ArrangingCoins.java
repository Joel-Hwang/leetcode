package Easy;

import org.testng.annotations.Test;

public class _441_ArrangingCoins {

    /*
    1+2+3+4+5+... <= n 
    k(k+1)/2 <= n
    k^2+k-2n <= 0
    k = (-1+root(1+8n) )/2
    */
    public int arrangeCoins(int n) {
        return (int)(-1 + Math.sqrt(1+8*(long)n) )/2;
    }

    @Test
    public void test(){
        System.out.println(arrangeCoins(1804289383));
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(10));
    }
}
