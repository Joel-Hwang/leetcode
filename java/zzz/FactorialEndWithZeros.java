package zzz;

import org.testng.annotations.Test;

public class FactorialEndWithZeros {
    public int solution(int n){
        int res = 0;
        while(n>0){
            n/=5;
            res += n;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(solution(100));
    }
}
