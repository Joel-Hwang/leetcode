package Easy;

import org.testng.annotations.Test;

public class _121_BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i<prices.length; i++){
            if(prices[i] < minPrice) minPrice = prices[i];
            else res = Math.max(prices[i]-minPrice,res);
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
