package Hard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _44_WildcardMatching{
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for(int i = 1; i<dp[0].length; i++){
            if(p.charAt(i-1) == '*') dp[0][i] = dp[0][i-1];
        }

        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[i].length; j++){
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j];
                }else if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
       
        /*System.out.println(p);
        for(int i = 0; i<dp.length; i++){
            if(i>0)
                System.out.print(s.charAt(i-1));
            for(int j = 0; j<dp[i].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        return dp[s.length()][p.length()];
    }

    @Test
    public void test(){
        assertFalse(isMatch("aab", "c*a*b"));
        assertTrue(isMatch("aa", "*"));
        assertTrue(isMatch("adceb", "*a*b"));
        assertFalse(isMatch("acdcb", "a*c?b"));
    }
}


// *b?d* ? charAt(d) - charAt(b) = 1 + count(?)
//bcd
//bbbbbbbaddcbcdaaaaaabaacd