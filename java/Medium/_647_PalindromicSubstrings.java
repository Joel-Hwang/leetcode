package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        int res = 1;
        if(s== null || s.length() == 0) return 0;
        for(int i = 1; i<s.length(); i++){
            res += rec(s,i,i);
            res += rec(s,i-1,i);
        }

        return res;
    }

    private int rec(String s, int l, int r){
        int res = 0;
        while(l>=0 && r<s.length() && s.charAt(r)==s.charAt(l)){
            res++; l--; r++;
        }  
        return res;
    }

    @Test
    public void test(){
        assertEquals(6,countSubstrings("aaa"));
    }
}
