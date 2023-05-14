package Medium;

import org.testng.annotations.Test;

public class _2110_NumberOfSmoothDescentPeriodsOfAStock {
    public long getDescentPeriods(int[] prices) {
        long res = prices.length;
        int start = -1;
        for(int i = 0; i<prices.length-1; i++){
            if(prices[i]-1 == prices[i+1]){
                if(start<0) start = i;
            }else{
                if(start>=0){
                    long n = i-start+1;
                    long sum = n*(n-1)/2;
                    res += sum;
                }
                start = -1;
            }
        }

        if(start>=0){
            long n = prices.length-start;
            long sum = n*(n-1)/2;
            res += sum;
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(getDescentPeriods(new int[]{12,11,10,9,8,7,6,5,4,3,4,3,10,9,8,7}));
    }
}
