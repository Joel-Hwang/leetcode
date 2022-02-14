package Easy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int cursorS = 0;
        if("".equals(s)) return true;
        for(int i = 0; i<t.length(); i++){
            if(s.charAt(cursorS) == t.charAt(i)){
                cursorS++;
            }
            if(cursorS>=s.length()) return true;
        }
        return false;
    }

    @Test
    public void test(){
        assertTrue(isSubsequence("abc", "ahbgdc"));
        assertFalse(isSubsequence("axc", "ahbgdc"));
    }
}
