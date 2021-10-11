package Easy;

import org.testng.annotations.Test;

public class _125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] ar = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : ar){
            if(('a'<=c && c<='z') ||('0'<=c && c<='9') ) sb.append(c);
        }

        for(int i = 0; i<sb.length()/2; i++ ){
            if(sb.charAt(i) != sb.charAt(sb.length()-1-i)) return false;
        }

        return true;
    }

    @Test
    public void test(){
        System.out.println(isPalindrome("A man, a palan, a canal: Panama"));
    }
}
