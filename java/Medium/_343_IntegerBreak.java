package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _343_IntegerBreak {
    public int integerBreak(int n) {
        if(n == 2) return 1; 
        if(n == 3) return 2; 
        if(n == 4) return 4;

        int res = 1;
        while(n>4){
            n -= 3;
            res *= 3;
        }
        //if(n==4) return res*4;
        //if(n==3) return res*3;
        //if(n==2) return res*2;

        return res*n;
    }

    @Test
    public void test(){
        assertEquals(6, integerBreak(5));
        assertEquals(9, integerBreak(6));
        assertEquals(12, integerBreak(7));
        assertEquals(18, integerBreak(8));
        assertEquals(27, integerBreak(9));
        assertEquals(36, integerBreak(10));
    }
}
