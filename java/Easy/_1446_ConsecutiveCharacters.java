package Easy;

import org.testng.annotations.Test;

public class _1446_ConsecutiveCharacters {
    public int maxPower(String s) {
        int res = 0;
        int cur = 0;
        char prevC = ' ';
        for(char c : s.toCharArray()){
            if( c == prevC)
                cur++;
            else{
                res = Math.max(res, cur);
                cur = 1;
                prevC = c;
            }
        }
        res = Math.max(res, cur);
        return res;
    }

    @Test
    public void test(){
        System.out.println(maxPower("hooraaaaaaaaaaay"));
    }
}
