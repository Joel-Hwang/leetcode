package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.testng.annotations.Test;

public class _2087_MinimumCostHomecomingOfaRobotInaGrid {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int res = 0;
        if(startPos[0]<= homePos[0])
            for(int i = startPos[0]+1; i<=homePos[0]; i++)
                res += rowCosts[i];
        else
            for(int i = startPos[0]-1; i>=homePos[0]; i--)
                res += rowCosts[i];

        if(startPos[1] <= homePos[1])
            for(int i = startPos[1]+1; i<=homePos[1]; i++)
                res += colCosts[i];
        else
            for(int i = startPos[1]-1; i>=homePos[1]; i--)
                res += colCosts[i];

        return res;
    }

    

    @Test
    public void test(){
        assertEquals(18, minCost(new int[]{1,0}, new int[]{2,3}, new int[]{5,4,3}, new int[]{8,2,6,7}));
    }
}
