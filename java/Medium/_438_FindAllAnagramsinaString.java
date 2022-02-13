package Medium;
import java.util.*;

import org.testng.annotations.Test;

public class _438_FindAllAnagramsinaString {
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList();
        int[] iP = new int[26];
        for(int i = 0; i<p.length(); i++)
            iP[p.charAt(i)-'a']++;

        for(int i = 0; i<s.length()-p.length()+1; i++){
            if(isAnagram2(iP, s.substring(i,i+p.length())))
                res.add(i);
        }
        return res;
    }

    private boolean isAnagram2(int[] a, String b){
        int[] ib = new int[26];
        for(int i = 0; i<b.length(); i++)
        ib[b.charAt(i)-'a']++;

        for(int i = 0; i<a.length; i++){
            if (a[i] != ib[i]) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();

        

        return res;
    }

    @Test
    public void test(){
        findAnagrams("abab", "ab");
        findAnagrams("cbaebabacd", "abc");
    }
}
