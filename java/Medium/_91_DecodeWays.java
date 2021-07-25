package Medium;

import org.testng.annotations.Test;

public class _91_DecodeWays {
    public int numDecodings(String s) {
        if(s.startsWith("0")) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<s.length()+1; i++){
            if(s.charAt(i-1) == '0' && s.charAt(i-2)>'2' ) return 0;

            if(s.charAt(i-1) == '0' ) dp[i] = dp[i-1];
            else if(isConvertable(s.charAt(i-2), s.charAt(i-1)))
                dp[i] = dp[i-1]+dp[i-2];
            else dp[i] = dp[i-1];
        }
        return dp[dp.length-1];
    }

    private boolean isConvertable(char a, char b){
        if(a == '0' || a >'2') return false;
        if(a == '2' && b > '6') return false;
        return true;
    }

    @Test
    public void test(){
        System.out.println(numDecodings("2101"));
        System.out.println(numDecodings("10"));
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("06"));
    }
}
