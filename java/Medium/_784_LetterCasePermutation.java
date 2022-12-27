package Medium;
import java.util.*;

import org.testng.annotations.Test;
public class _784_LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        return dfs("",s);
        
    }
    
    private List<String> dfs(String p, String s ){
        List<String> res = new ArrayList<>();
        if(hasNoChar(s)){
            res.add(p+s);
            return res;
        }
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isChar(c)){
                char other = getOther(c);
                res.addAll(dfs(p+s.substring(0, i)+c,s.substring(i+1)));
                res.addAll(dfs(p+s.substring(0, i)+other,s.substring(i+1)));
                break;
            }
        }
        return res;
    }
    boolean hasNoChar(String s){
        for(char c : s.toCharArray()){
            if(isChar(c)) return false;
        }
        return true;
    }
    boolean isChar(char c){
        return (0<=c-'A' && c-'A' <=26) || (0<=c-'a' && c-'a' <=26);
    }
    char getOther(char c){
        return (0<=c-'A' && c-'A' <=26)?(char)(c+32):(char)(c-32);
    }

    @Test
    public void test(){
        letterCasePermutation("a1b2");
    }
}
