package Hard;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _899_OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String min = s;
            for(int i = 0; i<s.length(); i++){
                String cur = s.substring(i+1) + s.substring(0,i+1);
                if(min.compareTo(cur)>0) min = cur;
            }
            return min;
        }
        char[] arC = s.toCharArray();
        Arrays.sort(arC);
        return new String(arC);
    }

    @Test
    public void test(){
        System.out.println(orderlyQueue("cba", 1));
    }
}