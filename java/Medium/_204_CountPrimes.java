package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _204_CountPrimes {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        int res = 0;
        boolean[] isPrimes = new boolean[n];
        isPrimes[0] = true;
        isPrimes[1] = true;
        for(int i = 2; i<n; i++){
            if(!isPrimes[i]){
                res++;
                for(int j = 2; i*j<n; j++ )
                    isPrimes[i*j] = true;
            }
        }
        return res;
    }

    @Test
    public void test(){
        assertEquals(4, countPrimes(10));
    }
}
