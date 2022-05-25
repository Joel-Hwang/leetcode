package Hard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.testng.annotations.Test;

public class _780_ReachingPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(sx<tx && sy<ty){
            if(tx > ty) tx %= ty;
            else ty %= tx;
        }
        return sx == tx && sy<=ty && (ty-sy)%sx == 0 || 
                sy == ty && sx<=tx && (tx-sx)%sy == 0;
    }

    @Test
    public void test(){
        assertTrue(reachingPoints(1,1,3,5));
        assertFalse(reachingPoints(35,13,455955547,420098884));
        assertTrue(reachingPoints(1,1,1,1));
        assertFalse(reachingPoints(1,1,2,2));
    }
}
