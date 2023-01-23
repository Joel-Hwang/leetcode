package Easy;
import java.util.*;

import org.testng.annotations.Test;

public class _1805_NumberofDifferentIntegersinaString {
    public int numDifferentIntegers(String word) {
        for(char c = 'a'; c <= 'z'; c++)
            word = word.replace(c, ' ');
        String[] digits = word.split(" ");
        Set<String> set = new HashSet<>();
        for(String digit : digits){
            if("".equals(digit)) continue;
            digit = removeLeadingZeros(digit);
            set.add(digit);
        }
        return set.size();
    }

    private String removeLeadingZeros(String s){
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) != '0') return s.substring(i);
        }
        return "0";
    }

    @Test
    public void test(){
        numDifferentIntegers("0i00e");
    }    
}
