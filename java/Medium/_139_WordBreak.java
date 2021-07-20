package Medium;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

//DP
public class _139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        for(int i = 1; i<=s.length(); i++){
            for(int j = 0; j<i; j++){
                if(f[j] && wordDict.contains(s.substring(j,i)))
                    f[i] = true;
            }
        }
        return f[f.length-1];
    }

    



    @Test
    public void test(){
        assertTrue( wordBreak("ddadddbdddadd", Arrays.asList(new String[]{"dd","ad","da","b"})) );
        assertFalse( wordBreak("catsandog", Arrays.asList(new String[]{"cats","dog","sand","and","cat"})) );
        assertTrue( wordBreak("applepenapple", Arrays.asList(new String[]{"apple","pen"})) );
        assertTrue( wordBreak("leetcode", Arrays.asList(new String[]{"leet","code"})) );
        assertFalse( wordBreak("cbca", Arrays.asList(new String[]{"bc","ca"})) );
    }
}
    