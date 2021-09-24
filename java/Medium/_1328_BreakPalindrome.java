package Medium;

import org.testng.annotations.Test;

public class _1328_BreakPalindrome {
    public String breakPalindrome2(String palindrome) {
        if (palindrome.length() == 1)
            return "";
        String post = palindrome.substring(0, palindrome.length() - 1) 
        + (palindrome.charAt(palindrome.length() - 1) == 'a'?'b':'a');

        String pre = palindrome;
        for(int i = 0; i<palindrome.length()/2; i++){
            if(pre.charAt(i) != 'a'){
                pre = pre.substring(0,i)+"a"+pre.substring(i+1);
                break;
            }
        }
        if(pre.equals(palindrome)) return post;

        return pre;
    }

    public String breakPalindrome(String palindrome) {
        char[] arC = palindrome.toCharArray();

        for(int i = 0; i<arC.length/2; i++){
            if(arC[i] != 'a'){
                arC[i] = 'a';
                return String.valueOf(arC);
            }
        }

        arC[arC.length-1] = 'b'; //all a
        return palindrome.length()>1?String.valueOf(arC):"";
    }
    

    @Test
    public void test() {
        System.out.println(breakPalindrome("abccba"));
        System.out.println(breakPalindrome("abaaaba"));
        System.out.println(breakPalindrome("a"));
        System.out.println(breakPalindrome("aa"));
        System.out.println(breakPalindrome("aba"));

    }
}
