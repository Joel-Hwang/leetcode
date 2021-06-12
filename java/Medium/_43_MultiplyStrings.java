package Medium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        char[] cn1 = num1.toCharArray();
        char[] cn2 = num2.toCharArray();
        int res = 0;
        for(int i = cn2.length-1,j=0; i>=0; i--,j++){
            res += calc(cn1,cn2[i])*(int)Math.pow(10, j);
        } 

        return res+"";
    }

    public int calc(char[] cn, char c){
        int res = 0;
        int div = 0;
        for(int i = cn.length-1,j=0; i>=0; i--,j++){
            int mul = (cn[i]-'0')*(c-'0') + div;
            int remain = mul%10;
            res = res + remain*(int)Math.pow(10, j);
            div = mul/10;
        }
        if(div>0)res = res + div*(int)Math.pow(10, cn.length);
        return res;
    }

    @Test
    public void test(){
        
        //System.out.println(calc(new char[]{'1','2','3'},'6'));
        assertTrue("6".equals(multiply("2","3")));
        assertTrue("56088".equals(multiply("123","456")));
    }
}
