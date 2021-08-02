package Easy;

import org.testng.annotations.Test;

public class _409_LongestPalindrome {
    public int longestPalindrome(String s) {
        int res = 0;
        char[] arC = s.toCharArray();
        int[] az = new int[58];
        for(char c : arC){
            az[c-'A']++;
        }
        for(int i : az){
            res += (i/2)*2;
        }
        return res == s.length()?res:res+1;
    } 

    @Test
    public void test(){
        System.out.println(longestPalindrome("AAAAA"));
        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("bb"));
    }
}
