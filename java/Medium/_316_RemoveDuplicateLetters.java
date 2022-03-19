package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.testng.annotations.Test;

public class _316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); i++) lastIndex[s.charAt(i) - 'a'] = i;
        
        boolean[] seen = new boolean[26];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            int c = s.charAt(i) - 'a';
            if(seen[c]) continue;
            while(!stk.isEmpty() && stk.peek() > c && i<lastIndex[stk.peek()] ){
                seen[stk.pop()] = false;
            }
            stk.push(c);
            seen[c] = true;
            
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append((char)(stk.pop()+'a'));
        }
        return sb.reverse().toString();

    }

    @Test
    public void test(){
        assertEquals("abc", removeDuplicateLetters("bcabc"));
        assertEquals("acdb", removeDuplicateLetters("cbacdcbc"));
    }
}
