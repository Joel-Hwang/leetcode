package Easy;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _2144_MinimumCostOfBuyingCandiesWithDiscount {
    public int minimumCost(int[] cost) {
        int res = 0;

        Arrays.sort(cost);
        for(int i = cost.length-1,j=1; i>=0;i--,j++){
            if(j%3 ==0) continue;
            res += cost[i];
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(minimumCost(new int[]{3,2,1}));
    }
}
