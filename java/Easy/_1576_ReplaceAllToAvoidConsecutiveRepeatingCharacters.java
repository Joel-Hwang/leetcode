package Easy;

import java.util.*;

import org.testng.annotations.Test;

public class _1576_ReplaceAllToAvoidConsecutiveRepeatingCharacters {
    public String modifyString(String s) {
        char[] arC = s.toCharArray();

        for(int i = 0; i<arC.length; i++){
            if(arC[i] != '?') continue;
            for(char c = 'a'; c <= 'z';c++){
                arC[i] = c;
                if(i>0 && arC[i-1] == c) continue;
                if(i<arC.length-1 && arC[i+1] == c) continue;
                break;    
            }
        }
        return new String(arC);
    }

    

    @Test
    public void test(){
        System.out.println(modifyString("???"));
    }
}
