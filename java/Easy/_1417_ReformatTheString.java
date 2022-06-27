package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _1417_ReformatTheString {
    public String reformat(String s) {
        int cntLetter = 0;
        int cntDigit = 0;
        char[] letters = new char[500];
        char[] digits = new char[500];
        
        for(char c : s.toCharArray()){
            if ( '0' <= c && c <= '9' )
                digits[cntDigit++] = c;
            else letters[cntLetter++] = c;
        }

        if(Math.abs(cntDigit - cntLetter) > 1 ) return "";

        StringBuilder sb = new StringBuilder();
        if(cntLetter > cntDigit){
            for(int i = 0; i < cntLetter; i++){
                sb.append(letters[i]);
                if(i<cntDigit) sb.append(digits[i]);
            }
        }else{
            for(int i = 0; i < cntDigit; i++){
                sb.append(digits[i]);
                if(i<cntLetter)  sb.append(letters[i]);
            }
        }

        return sb.toString();
    }

    @Test
    public void test(){
        assertEquals("0a1b2c", reformat("a0b1c2"));
    }
}
