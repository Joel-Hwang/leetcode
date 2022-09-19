package Easy;

public class _242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] ar = new int[26];
        for(int i = 0; i<s.length();i++) ar[s.charAt(i)-'a']++;
        for(int i = 0; i<t.length();i++) ar[t.charAt(i)-'a']--;
        for(int a : ar) if(a!=0) return false;
        return true;
    }    
}
