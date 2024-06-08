package Easy;

import org.testng.annotations.Test;

public class _1844_ReplaceAllDigitsWithCharacters {
    public String replaceDigits(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<s.length(); i+=2){
            sb.append(s.charAt(i));
            if(i+1<s.length()){

                char next = (char)((int)(s.charAt(i))+(int)(s.charAt(i+1)-48));
                sb.append(next);
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(replaceDigits("a1c1e1"));
        System.out.println(replaceDigits("a1b2c3d4e"));
    }
}
