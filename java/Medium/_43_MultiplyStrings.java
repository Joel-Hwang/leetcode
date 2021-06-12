package Medium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _43_MultiplyStrings {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) return "0";
        if("1".equals(num1)) return num2;
        if("1".equals(num2)) return num1;

        StringBuilder sb = new StringBuilder();
        char[] cn1 = num1.toCharArray();
        char[] cn2 = num2.toCharArray();
        
        StringBuilder[] arSb = new StringBuilder[cn2.length];
        String ws = "";
        for(int i = cn2.length-1; i>=0; i--){
            StringBuilder row =  calc(cn1,cn2[i]);
            row.insert(0,ws);
            arSb[i] = row;
            ws +="0";
        }

        int div = 0;
        for(int i = 0; i<arSb[0].length(); i++){
            int digit = 0;
            for(StringBuilder ssb : arSb){
                if(ssb.length()>i){
                    digit += (ssb.charAt(i)-'0');
                }
            }
            int remain = (digit+div)%10;
            sb.insert(0, remain);
            div = (digit+div)/10;
        }
        if(div>0)sb.insert(0, div);

        return sb.toString();
    }

    public StringBuilder calc(char[] cn, char c){
        StringBuilder sb = new StringBuilder();
        int div = 0;
        for(int i = cn.length-1; i>=0; i--){
            int mul = (cn[i]-'0')*(c-'0') + div;
            int remain = mul%10;
            sb.append( remain);
            div = mul/10;
        }
        if(div>0)sb.append( div);
        return sb;
    }


    public String multiply2(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
       
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
    
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
        
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    @Test
    public void test(){
        
        //System.out.println(calc(new char[]{'1','2','3'},'6'));
       // assertTrue("6".equals(multiply("2","3")));
        assertTrue("56088".equals(multiply("123","456")));
    }
}
