package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _1758_MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        int diffCntWith10 = 0;
        int diffCntWith01 = 0;

        for(int i = 0; i<s.length(); i++) {
            int COMPARE = i%2;

            if(s.charAt(i)-'0' != COMPARE ){
                diffCntWith01++;
            }else{
                diffCntWith10++;
            }
        }

        return Math.min(diffCntWith01, diffCntWith10);
    }

    public int minOperations2(String s) {
        int res = 0, n = s.length();
        for (int i = 0; i < n; ++i)
            if (s.charAt(i) - '0' != i % 2)
                res++;
        return Math.min(res, n - res);
    }

    @Test
    public void test(){
        assertEquals(1,minOperations("0100"));
    }
}
