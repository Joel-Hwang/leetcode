package Medium;

import org.testng.annotations.Test;

public class _1759_CountNumberOfHomogenousSubstrings {
    public int countHomogenous(String s) {
        long res = 0;
        long curCnt = 1;
        int mod = 1000000007;
        for(int i = 1; i< s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1))
                curCnt++;
            else{
                res += (curCnt+1)%mod*(curCnt)%mod/2;
                curCnt = 1;
            }
        }
        res += (curCnt+1)%mod*(curCnt)%mod/2;
        return (int)res;
    }

    @Test
    public void test(){
        System.out.println(countHomogenous("a"));
        System.out.println(countHomogenous("aaa"));
        System.out.println(countHomogenous("aaabbb"));
    }
}
