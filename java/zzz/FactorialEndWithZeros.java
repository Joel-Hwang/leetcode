package zzz;

import org.testng.annotations.Test;

public class FactorialEndWithZeros {
    public int solution(int n){
        int res = 0;
        while(n>0){
            int cnt = n/5;
            res += cnt;
            n/=5;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(solution(100));
    }
}
