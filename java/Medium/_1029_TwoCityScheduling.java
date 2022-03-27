package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _1029_TwoCityScheduling{
    public int twoCitySchedCost(int[][] costs) {
        int aCnt, bCnt, aSum, bSum;
        aCnt = bCnt = aSum = bSum = 0;
        Arrays.sort(costs,(int[] o1, int[] o2)->{
            return Math.abs(o2[0]-o2[1]) -  Math.abs(o1[0]-o1[1]);
        });

        for(int[] cost : costs){
            if( (aCnt < costs.length/2 && cost[0] < cost[1]) || bCnt == costs.length/2){ 
                aSum += cost[0];
                aCnt++;
            }else{
                bSum += cost[1];
                bCnt++;
            }
        }
        return aSum + bSum;
    }

    @Test
    public void test(){
        assertEquals(1859, twoCitySchedCost(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));
        assertEquals(110, twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
    }
}