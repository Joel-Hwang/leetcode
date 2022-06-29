package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _1359_CountAllValidPickupAndDeliveryOptions {
    /*
    n = 1일 때 경우는 1개 (p1, d1) dp[0] = 1
    n = 2일때 자리는 4개(p1,d1,p2,d2)
    p1이 가장 앞에 있을때 d1이 가능한 경우를 보면
    O   O   O   O
    P1  D1
    P1      D1
    P1          D1

    이렇게 3가지 경우이고 (n*2)-1
    각 경우에 2자리가 비게 되니까 dp[0]만큼 가능
    또 P2가 가장 앞에 올수도 있기 때문에 p2에 대해서도 반복.
    즉 dp[1] = 3 * dp[0] * 2 = 6
    3은 P1이 앞에 있을때 D1이 가능한 경우의 수
    dp[0]은 P1과 D1을 뺀 빈자리에 대한 경우의 수
    2는 P1, P2에 대해 계산해야 하니까 2

    n = 3일때 자리는 6개(p1,d1,p2,d2,p3,d3)
    p1이 가장 앞에 있을때 d1이 가능한 경우를 보면
    O   O   O   O   O   O
    P1  D1 
    P1      D1 
    P1          D1 
    P1              D1 
    P1                  D1
    이렇게 5가지 경우이고 (n*2)-1
    각 경우에 4자리가 비게 되니까 dp[1]만큼 가능
    또 P2, P3이 가장 앞에 올수도 있어서 3만큼 반복
    즉 dp[2] = 5 * dp[1] * 3 = 90
    
    일반화를 해보면 이렇게 됨. i+1은 dp는 배열로 인덱스가 0부터 시작하기 때문
    dp[i] = ( 2*(i+1)-1 ) * dp[i-1] * (i+1)
    
    */
    public int countOrders(int n) {
        long[] dp = new long[n];
        dp[0] = 1;
        for(int i = 1; i<dp.length; i++) {
            dp[i] = ( (2*(i+1)-1) * dp[i-1] * (i+1) )% 1000000007 ;
        }
        return (int)(dp[dp.length-1] % 1000000007);
    }

    @Test
    public void test(){
        assertEquals(1, countOrders(1));
        assertEquals(6, countOrders(2));
        assertEquals(90, countOrders(3));
        assertEquals(368349166, countOrders(18));
    }

}
