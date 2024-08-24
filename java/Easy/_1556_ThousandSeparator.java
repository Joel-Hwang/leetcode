package Easy;

import org.testng.annotations.Test;

public class _1556_ThousandSeparator {
    public String thousandSeparator(int n) {
        StringBuffer sb = new StringBuffer();
        while(n>999){
            int mod = n%1000;
            n/=1000;
            sb.insert(0,String.format("%03d", mod)).insert(0,".");
        }
        sb.insert(0, n);

        return sb.toString();
    }
    
    public String thousandSeparator2(int n) {
        String num = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = num.length(); i > 0; i -= 3) {
            if (sb.length() > 0) sb.insert(0, ".");
            sb.insert(0, num.substring(Math.max(0, i - 3), i));
        }
        return sb.toString();
    }


    @Test
    public void test(){
        System.out.println(thousandSeparator(51040));
        System.out.println(thousandSeparator(1234567));
    }
}
