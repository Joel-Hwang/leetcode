package Medium;

import org.testng.annotations.Test;

public class _122_BestTimetoBuyandSellStockII {
    public int maxProfit2(int[] prices) {

        int buy = -prices[0], sell = 0;
        for (int p : prices) {
            buy = Math.max(buy, sell - p);
            sell = Math.max(sell, buy + p);
        }

        return sell;
    }
    /*
    buy : 현재까지 팔았던 최대이익 - 현재 물건의 가격 => 물건 사고 남은돈
    sell : 물건사고 남은돈의 최대치 + 현재 물건의 가격 => 있는 돈은 따로 있고 거기다 현재 가격에 물건 팜

    1번째 물건일때 : 7
    buy : 현재까지 판 최대 이익이 -현재물건값 => -prices[0] => -7
    sell : 현재이익(-prices[0]) + 현재물건 가격 prices[0] = 0
    
    2번째 물건일때 : 1
    buy : 현재까지 판 최대 이익(0) - 현재물건값(1) => -1 
    // 1번째 물건보다는 그래도 물건 사고 남은돈이 늘었으니까 -1로 저장
    // 즉 7일때 사는것보단 1일때 사는게 낫다
    sell : 현재이익(-1) + 현재물건값(1) => 0

    3번쨰 물건일때 : 5
    buy : 현재까지 판 최대 이익(0) - 현재물건값(5) => -5
    //2번째까지 샀을 때 이익이 -1이였으니까 3번째는 안사는게 맞다. 즉 계속 -1
    sell : 현재이익(-1) + 현재물건값(5) => 4
    //이번에 팔아서 이득이 4가 됐으니까 여기서는 팔아야 한다.

    4번째 물건일때 : 3
    buy : 현재까지 판 최대이익(4) - 물건값(3) => 1
    //현재이득을 가지고 물건을 샀음에도 1이라는 이득이 있음.
    //3까지 왔을때 사고팔고 어쩌고 마지막에 샀을때 최대 이득이 1임
    sell : 현재이익(1)+물건값(3) = 4
    //3번째랑 이익이 같기 때문에 팔아도 되고 안팔아도 됨.
    //최대 이익이 4라는 의미(1원에 사서 5원에 팔거나)
    (1원에 사서 5원에 팔고 3원에 사서 3원에 팔았다는 의미)


    5번째 물건일때 : 6
    buy : 현재 판매 최대이익(4) - 물건값(6) => -2
    //5번째까지 사고팔고 어쩌고 마지막에 샀을때 이전보다 적기 때문에 여기선 안사는게 이득
    sell : 현재이익(1) + 물건값(6) => 7
    //5번째 물건을 구입했건 어쨌건 여기까지 buy 이득이 1이니까 여기서 물건 6에 팔면 7

    6번째 : 4
    buy : 현재 판매 최대이익(7) - 물건값(4) => 3
    //여기까지 앞에서 사고팔고 뭐했던 최대가 1이였는데 6번을 사버리면 3이 되니까 사야됨
    sell : 현재이익(3) + 물건값(4) => 7
    //5번째까지 사고 팔았던 최대 이익이 7원이고 6번째에서 사고 바로 팔아버려도 7원
    */

    public int maxProfit(int[] prices) {
        //
        //1, 7, 2, 3, 6, 7, 6, 7
        //1에사서 7에 팔고 , 확정
        //2에 사서 3에 팔고 3에 사서 6에 팔고 6에 사서 7에 팔면 5원
        //2에 사서 6에 팔고 6에 사서 7에 팔아도 5원
        //2에 사서 7에 팔아도 5원. 즉 이득 볼때마다 더하면 다 똑같다.
        int res = 0;
        for (int i = 1; i<prices.length; i++) {
            if(prices[i]> prices[i-1]) //팔 가치가 있으면
                res += prices[i]-prices[i-1];
        }

        return res;
    }
    @Test
    public void test(){
        System.out.println(maxProfit(new int[]{1, 7, 2, 3, 6, 7, 6, 7}));
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
