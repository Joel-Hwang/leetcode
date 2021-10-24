package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class _205_IsomorphicStrings {
    public boolean isIsomorphic2(String s, String t) {
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            if(mapST.getOrDefault(s.charAt(i),t.charAt(i)) != t.charAt(i) ) return false;
            if(mapTS.getOrDefault(t.charAt(i),s.charAt(i)) != s.charAt(i) ) return false;
            mapST.put(s.charAt(i), t.charAt(i));
            mapTS.put(t.charAt(i), s.charAt(i));
        }

        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        int[] m = new int[512];
        for(int i = 0; i<s.length(); i++){
            if(m[s.charAt(i)] != m[t.charAt(i)+256]) return false;
            m[s.charAt(i)] = m[t.charAt(i)+256] = i+1;
        }
        return true;

    }


    @Test
    public void test(){
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("egcd", "adfd"));
        System.out.println(isIsomorphic("abab", "baba"));
    }
}

