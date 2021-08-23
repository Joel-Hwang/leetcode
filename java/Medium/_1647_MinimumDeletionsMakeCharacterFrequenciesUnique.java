package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.testng.annotations.Test;

public class _1647_MinimumDeletionsMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        char[] cs = s.toCharArray();
        HashMap<Character, Integer> map= new HashMap<>();
        ArrayList<MyData> ar = new ArrayList<>();
        for(char c : cs){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : map.keySet()){
            ar.add(new MyData(c, map.get(c)));
        }

        Collections.sort(ar, new Comparator<MyData>(){
            public int compare(MyData o1, MyData o2) {
                return o1.cnt = o2.cnt;
            };
        });

        

        return 0;
        
    }

    class MyData{
        char c;
        int cnt;
        public MyData(char c, int cnt){
            this.c = c;
            this.cnt = cnt;
        }
    }

    @Test
    public void test(){
        System.out.println(minDeletions("abcabcab"));
    }
}
