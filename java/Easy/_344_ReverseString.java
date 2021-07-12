package Easy;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _344_ReverseString {
    public void reverseString(char[] s) {
        for(int i = 0; i<s.length/2; i++){
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }
    @Test
    public void test(){
        char[] a = {'h','e','l','l','o'};
        reverseString(a);
        System.out.println(Arrays.toString(a));
    }
}
