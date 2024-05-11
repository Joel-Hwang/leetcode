package Medium;

import org.testng.annotations.Test;

public class _1864_MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {
    public int minSwaps(String s) {
        int differ = 0;
        for(char c: s.toCharArray())
            differ = differ + (c=='1'?+1:-1);
        if(Math.abs(differ)>1) return -1;
        if(isAlternating(s)) return 0;

        int result = 0;
        if(differ == 0){
            int temp = 0;
            for(int i = 0; i<s.length()-1; i+=2){
                if(s.charAt(i) != '0') temp++;
                if(s.charAt(i+1) != '1') temp++;
            }
            for(int i = 0; i<s.length()-1; i+=2){
                if(s.charAt(i) != '1') result++;
                if(s.charAt(i+1) != '0') result++;
            }
            result = Math.min(temp,result);
        }else if(differ == 1){
            for(int i = 0; i<s.length(); i+=2){
                if(s.charAt(i) != '1') result++;
                if(i+1==s.length()) break;
                if(s.charAt(i+1) != '0') result++;
            }
        }else{
            for(int i = 0; i<s.length(); i+=2){
                if(s.charAt(i) != '0') result++;
                if(i+1==s.length()) break;
                if(s.charAt(i+1) != '1') result++;
            }
        }

        return result/2;
    }

    private boolean isAlternating(String s){
        for(int i = 1; i<s.length(); i++)
            if(s.charAt(i-1) == s.charAt(i))
                return false;
        return true;
    }

    @Test
    public void test(){
        System.out.println(minSwaps("100"));
        System.out.println(minSwaps("111000"));
    }
}
