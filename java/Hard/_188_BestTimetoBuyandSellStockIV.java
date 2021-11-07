package Hard;

import org.testng.annotations.Test;

public class _188_BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(k==0) return 0;
        int[][] buysell = new int[k][2];
        for(int i = 0; i<buysell.length; i++){
            buysell[i][0] = Integer.MAX_VALUE;
        }

        for(int p : prices){
            buysell[0][0] = Math.min(buysell[0][0],p);
            buysell[0][1] = Math.max(buysell[0][1],p-buysell[0][0]);
            for(int i = 1; i<buysell.length; i++){
                buysell[i][0] = Math.min(buysell[i][0],p-buysell[i-1][1]);
                buysell[i][1] = Math.max(buysell[i][1], p-buysell[i][0]);
            }
        }


        return buysell[k-1][1];
    }

    @Test
    public void test(){
        System.out.println(maxProfit(2, new int[]{2,4,1}));
    }


    public int maxProfit22(int[] prices) {
        int oneBuy = Integer.MAX_VALUE, twoBuy = Integer.MAX_VALUE;
        int oneBuyOneSell = 0,twoBuyTwoSell = 0;
        
        for(int p : prices){
            //가장 싼 가격에 살 수 있는놈
            oneBuy = Math.min(oneBuy, p);
            //가장 싸게 사서 가장 비싸게 살 수 있는놈 추적
            oneBuyOneSell = Math.max(oneBuyOneSell, p-oneBuy);
            //두번째 살때는 현재물건 가격 - 첫번째 사고팔아서 얻은 이득 
            twoBuy = Math.min(twoBuy,p-oneBuyOneSell);
            //두번째 팔때는 두번째 산 가격과 현재 가격의 차이
            twoBuyTwoSell = Math.max(twoBuyTwoSell, p-twoBuy);
            /*System.out.println("price : " + p);
            System.out.println("oneBuy : " + oneBuy);
            System.out.println("oneBuyOneSell : " + oneBuyOneSell);
            System.out.println("twoBuy : " + twoBuy);
            System.out.println("twoBuyTwoSell : " + twoBuyTwoSell);
            System.out.println("========================");*/
        }

        return twoBuyTwoSell;
    }
}
