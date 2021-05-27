package Medium;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testng.annotations.Test;

public class _38_CountSay {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String res = "1";
        for(int i = 1; i<n; i++){
            res = say(res);
        }

        return res;
    }

    public String say(String a){

        char[] arC = a.toCharArray();
        StringBuilder res = new StringBuilder();
        int cnt = 1;
        for(int i = 1; i<arC.length; i++){
            if(arC[i] != arC[i-1]){
                res.append(cnt);
                res.append(arC[i-1]);
                cnt = 1;
                continue;
            } 
            cnt++;
        }

        res.append(cnt);
        res.append(arC[arC.length-1]);
        return res.toString();
    }

    @Test
    public void test(){
    //String + 사용 21%, ,StringBuilder : 99.76%
    
        String res = countAndSay(1);  //2
        res = countAndSay(2);  //2
        res = countAndSay(3);  //2
        res = countAndSay(4);  //2
        System.out.println(res);
        assertTrue("1211".equals(res),"Messageddddd");
    }
}
