package Easy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _680_ValidPalindromeII{
    public boolean validPalindrome(String s) {
        for(int i = 0; i<s.length()/2; i++){
            if(s.charAt(i) == s.charAt(s.length()-1-i)) continue;
            else{
                boolean left = isValid(s.substring(0,i) + s.substring(i+1));
                boolean right =isValid(s.substring(0,s.length()-1-i) + s.substring(s.length()-1-i+1));
                return left || right;
            }
        }
        return true;
    }

    private boolean isValid(String s){
        for(int i = 0; i<s.length()/2; i++)
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        return true;
    }

    @Test
    public void test(){
        Assert.assertEquals( false, validPalindrome("abc"));
        Assert.assertEquals( true, validPalindrome("deeee"));
        Assert.assertEquals( true, validPalindrome("aba"));
        Assert.assertEquals( true, validPalindrome("abca"));
    }
}