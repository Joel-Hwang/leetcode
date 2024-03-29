package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.testng.annotations.Test;

public class _1647_MinimumDeletionsMakeCharacterFrequenciesUnique {
    public int minDeletions2(String s) {
        int res = 0;
        char[] cs = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<MyData> ar = new ArrayList<>();
        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            ar.add(new MyData(c, map.get(c)));
        }

        Collections.sort(ar, new Comparator<MyData>() {
            public int compare(MyData o1, MyData o2) {
                return o2.cnt - o1.cnt;
            };
        });

        for (int i = 1; i < ar.size(); i++) {
            MyData prev = ar.get(i - 1);
            MyData dt = ar.get(i);
            if (prev.cnt <= dt.cnt) {
                res = res + dt.cnt - prev.cnt + 1;
                dt.cnt = prev.cnt - 1;
                if(dt.cnt<0){
                    res = res + dt.cnt;
                    dt.cnt = 0;
                }
            }
        }

        return res;

    }

    class MyData {
        char c;
        int cnt;

        public MyData(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }

    public int minDeletions(String s) {
        int res = 0;
        int[] freq = new int[26];
        for(int i = 0; i<s.length(); i++){
            freq[s.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        for(int i = 24; i>=0; i--){
            if(freq[i] == 0) break;
            if(freq[i+1] <= freq[i]){
                res = res + freq[i] - freq[i+1] + 1;
                freq[i] = freq[i+1] -1;
                if(freq[i]<0){
                    res = res + freq[i];
                    freq[i] = 0;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {

        System.out.println(minDeletions("bbcebab"));
        System.out.println(minDeletions("abcabc"));
        System.out.println(minDeletions("aab"));
        System.out.println(minDeletions("aaabbbcc"));
        System.out.println(minDeletions("ceabaacb"));
    }
}
