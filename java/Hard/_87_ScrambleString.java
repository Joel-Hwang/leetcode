package Hard;

import java.util.HashMap;

import org.testng.annotations.Test;

public class _87_ScrambleString {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;

        String key = s1 + s2;
        if(map.containsKey(key)) return map.get(key);
        boolean flag = false;
        int n = s1.length();
        for(int i = 1; i<s1.length(); i++){
            //swap
            String s1P1 = s1.substring(0, i);
            String s1P2 = s1.substring(i,n);
            boolean swap = isScramble(s1P1, s2.substring(n-i,n)) && isScramble(s1P2, s2.substring(0,n-i));
            boolean noswap = isScramble(s1P1, s2.substring(0, i)) && isScramble(s1P2, s2.substring(i,n));
            if(swap || noswap){
                flag = true;
                break;
            }
        }
        map.put(key, flag);
        return flag;
    }

    @Test
    public void test(){
        System.out.println(isScramble("great", "rgeat"));
    }
}
