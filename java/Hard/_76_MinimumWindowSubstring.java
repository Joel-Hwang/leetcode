package Hard;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

public class _76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        char[] arS = s.toCharArray();
        char[] arT = t.toCharArray();
        String res = "";
        LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<>();
        for(int i = 0; i<arT.length; i++){
            lhm.put(arT[i], -1);
        }

        for(int i = 0; i<arS.length; i++){
            if(!lhm.containsKey(arS[i])) continue;
            lhm.remove(arS[i]);
            lhm.put(arS[i], i);
            
            char startKey = lhm.keySet().iterator().next();
            int start = lhm.get(startKey);
            if(start < 0) continue;
            if("".equals(res) || res.length() > (i-start)){
                res = s.substring(start, i+1);
            }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
        System.out.println(minWindow("a","a"));
        System.out.println(minWindow("a","aa"));
    }

}

