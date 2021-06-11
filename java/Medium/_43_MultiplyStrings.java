package Medium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        char[] cn1 = num1.toCharArray();
        char[] cn2 = num2.toCharArray();
        int i = cn1.length-1;
        int j = cn2.length-1;
        int div = 0;
        while(i>=0 || j>=0){
            int numI = (i<0?0:cn1[i--]-'0');
            int numJ = (j<0?0:cn2[j--]-'0');

            int mul = numI*numJ;
            int remain = mul%10;
            sb.insert(0, remain+div);
            div = mul/10;
            
        }
        if(div>0)sb.insert(0, div);
        return sb.toString();
    }

    @Test
    public void test(){
        //assertTrue("6".equals(multiply("2","3")));
        assertTrue("56088".equals(multiply("123","456")));
    }
}
