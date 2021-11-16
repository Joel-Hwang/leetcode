package Easy;

import org.testng.annotations.Test;

public class _696_CountBinarySubstrings {

    

    public int countBinarySubstrings(String s) {
        int res = 0;
        int l = 0, r = 0;
        while( (l = s.substring(r).indexOf("01") ) >= 0) {
            l += r;
            r = l+1;
            while(l>=0 && s.charAt(l) == '0' && r<s.length() && s.charAt(r) == '1'){
                res++;
                l--;
                r++;
            }
        }
        l = 0; r = 0;
        while( (l = s.substring(r).indexOf("10") ) >= 0) {
            l += r;
            r = l+1;
            while(l>=0 && s.charAt(l) == '1' && r<s.length() && s.charAt(r) == '0'){
                res++;
                l--;
                r++;
            }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(countBinarySubstrings("10101"));
        System.out.println(countBinarySubstrings("00110011"));
    }
}
