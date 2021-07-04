package Hard;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.testng.annotations.Test;

public class _10_RegMatch {


    public boolean isMatch(String s, String p) {
        if(s== null || p == null) return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int j = 2; j<=p.length(); j+=2){
            if(p.charAt(j-1) == '*' && dp[0][j-2]) 
                dp[0][j] = true;
        }

        for(int i = 1; i<=s.length(); i++){
            for(int j = 1; j<=p.length(); j++){
                //p.charAt(j-1) = p의 현재 케릭터
                //s.charAt(i-1) = i의 현재 케릭터
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    if(p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.'){
                        dp[i][j] = dp[i][j-2];
                    }else {//if(p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.'){
                        //* count 0 : dp[i][j-2]
                        //* count 1 : dp[i-1][j-1]
                        //* count >1 :dp[i-1][j]
                        dp[i][j] = dp[i][j-2] || dp[i-1][j-1] || dp[i-1][j];
                    }
                }else{

                }
            }
        }
    
        return dp[s.length()][p.length()];
    }

    @Test
    public void test(){
        assertTrue(isMatch("aab", "c*a*b"));
    }

    
}