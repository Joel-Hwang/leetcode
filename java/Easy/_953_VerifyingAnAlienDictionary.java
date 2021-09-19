package Easy;

import java.util.HashMap;

import org.testng.annotations.Test;

public class _953_VerifyingAnAlienDictionary {
    //Use Array for dictionary takes 0ms (100%)
    //Use HashMap for dictionary takes 1ms(54.85%)
    //spacity is same.
    /*int[] dic = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i<order.length(); i++){
            dic[order.charAt(i) - 'a'] = i;
        }

        for(int i = 1; i<words.length; i++){
            if(!compare(words[i-1], words[i])) return false;
        }
        return true;
    }

    private boolean compare(String a, String b) {
        for(int i = 0; i<Math.min(a.length(), b.length()); i++){
            
            if(dic[a.charAt(i)- 'a'] < dic[b.charAt(i) - 'a']) return true;
            if(dic[a.charAt(i)- 'a'] > dic[b.charAt(i) - 'a']) return false;
        }
        if(a.length() > b.length())
            return false;

        return true;
    }
*/
    HashMap<Character, Integer> dic = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0; i<order.length(); i++){
            dic.put(order.charAt(i), i);
        }

        for(int i = 1; i<words.length; i++){
            if(!compare(words[i-1], words[i])) return false;
        }
        return true;
    }

    private boolean compare(String a, String b) {
        for(int i = 0; i<Math.min(a.length(), b.length()); i++){
            
            if(dic.get(a.charAt(i)) < dic.get(b.charAt(i))) return true;
            if(dic.get(a.charAt(i)) > dic.get(b.charAt(i))) return false;
        }
        if(a.length() > b.length())
            return false;

        return true;
    }
    @Test
    public void test(){
        System.out.println(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
