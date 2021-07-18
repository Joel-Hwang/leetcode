package Hard;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class _76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";

        Map<Character, Integer> dicT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) { //O(t)
            int count = dicT.getOrDefault(t.charAt(i), 0);
            dicT.put(t.charAt(i), count + 1);
        }

        int required = dicT.size();
        int l = 0, r = 0;
        int formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character,Integer>();
        int[] ans = {-1,0,0}; //length, left, right;

        while(r<s.length()){ //O(s)
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c,0);
            windowCounts.put(c, count+1);

            //현재 글자가 t에 있는 글자와 숫자까지 일치한지 검증
            if(dicT.containsKey(c) && windowCounts.get(c).intValue() == dicT.get(c).intValue()){
                formed++;
            }

            //현재 c까지 t의 내용이 s에 다 들어가 있으면
            while(l<=r && formed == required){
                c = s.charAt(l);
                //ans와 비교해서 더 작으면 현재 위치까지 저장 
                if(ans[0] == -1 || r-l+1 < ans[0]){
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                //원래 왼쪽 포인터는 지우면서 왼쪽 포인터 한칸 이동
                windowCounts.put(c, windowCounts.get(c)-1);
                if(dicT.containsKey(c) && windowCounts.get(c).intValue() < dicT.get(c).intValue()){
                    formed--;
                }
                l++;
            }
            r++;
        }

        return ans[0] == -1? "":s.substring(ans[1], ans[2]+1);
    }

    public String minWindow2(String s, String t) {
        char[] arS = s.toCharArray();
        char[] arT = t.toCharArray();
        String res = "";
        LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<>();
        for (int i = 0; i < arT.length; i++) {
            lhm.put(arT[i], -1);
        }

        for (int i = 0; i < arS.length; i++) {
            if (!lhm.containsKey(arS[i]))
                continue;
            lhm.remove(arS[i]);
            lhm.put(arS[i], i);

            char startKey = lhm.keySet().iterator().next();
            int start = lhm.get(startKey);
            if (start < 0)
                continue;
            if ("".equals(res) || res.length() > (i - start)) {
                res = s.substring(start, i + 1);
            }
        }

        return res;
    }

    @Test
    public void test() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }

}
