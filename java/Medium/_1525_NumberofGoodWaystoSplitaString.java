package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class _1525_NumberofGoodWaystoSplitaString {
    public int numSplits(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> cur = new HashMap<>();
        int res = 0;
        char[] arC = s.toCharArray();
        for(char c : arC){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(int i = 0; i<arC.length-1; i++){
            cur.put(arC[i], cur.getOrDefault(arC, 0)+1);

            //유일한 char면 없애버리고 아니면 cnt -1;
            if(map.get(arC[i]) == 1)
                map.remove(arC[i]);
            else
                map.put(arC[i], map.get(arC[i])-1);

            if(cur.size() == map.size()) res++;
            
        }
        return res;
    }


    //Brutal force. Time Limit
    public int numSplits2(String s) {
        int res = 0;
        for(int i = 1; i<s.length(); i++){
            String p1 = s.substring(0, i);
            String p2 = s.substring(i);
            if(getCnt(p1) == getCnt(p2))  res++;
        }
        return res;
    }

    private int getCnt(String s){
        char[] arC = s.toCharArray();
        Set set = new HashSet<>();
        for(char c : arC)
            set.add(c);
        return set.size();
    }

    @Test
    public void test(){
        System.out.println(numSplits("aacaba"));
        System.out.println(numSplits("abcd"));
        System.out.println(numSplits("aaaaa"));
    }
}
