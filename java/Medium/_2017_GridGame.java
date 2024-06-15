package Medium;
import java.util.*;

import org.testng.annotations.Test;
public class _2017_GridGame {
    public long gridGame(int[][] grid) {
        long expectedValue = Long.MAX_VALUE;

        long presum = 0;
        long bottom = 0;
        for(int i = 0; i<grid[0].length; i++)
            presum += grid[0][i];
        
        for(int i = 0; i<grid[0].length; i++){
            presum -= grid[0][i];

            if(i>0)
            bottom += grid[1][i-1];
            expectedValue = Math.min(expectedValue, Math.max(presum,bottom));
        }


        return expectedValue;
    }

    

    @Test
    public void test(){
        gridGame(new int[][]{{20,3,20,17,2,12,15,17,4,15},{20,10,13,14,15,5,2,3,14,3}});
    }
}
