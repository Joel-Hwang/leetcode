package Easy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int prev = (a.charAt(a.length()-1)-'0') + (b.charAt(b.length()-1)-'0');
        sb.insert(0, prev%2);
        for(int i = a.length()-2,j = b.length()-2; i>=0 || j>=0; i--,j--){
            int cur = (i<0?0:a.charAt(i)-'0') 
            + (j<0?0:b.charAt(j)-'0');
            cur += prev/2;
            sb.insert(0, cur%2);
            prev = cur;
        }
        if(prev>1)sb.insert(0, 1);
        return sb.toString();
    }

    @Test
    public void test(){
        assertTrue("1".equals(addBinary("0", "1")));
        assertTrue("100".equals(addBinary("11", "1")));
        assertTrue("10101".equals(addBinary("1010", "1011")));
    }



    
}
