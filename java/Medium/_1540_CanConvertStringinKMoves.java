package Medium;

import java.util.*;

import org.testng.annotations.Test;

public class _1540_CanConvertStringinKMoves {
    public boolean canConvertString(String s, String t, int k) {
        if(s.length() != t.length()) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            int gap = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if(gap == 0) continue;
            map.put(gap, map.getOrDefault(gap, 0)+1);
        }
        for(Integer key : map.keySet()){
            for(int i = 0; i<map.get(key); i++){
                int cnt = 26*i + key;
                if(cnt>k) return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(canConvertString("aab", "bbb", 27));
        System.out.println(canConvertString("abc", "bcd", 10));
        System.out.println(canConvertString("input", "ouput", 9));
    }
}
