package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

public class _1297_MaximumNumberofOccurrencesofaSubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int res = 0;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0; i < s.length()-minSize + 1; i++) {
            String sub = s.substring(i, i+minSize);
            if(isValid(sub, maxLetters)){
                int curCnt = map.getOrDefault(sub, 0);
                map.put(sub, curCnt+1);
                res = Math.max(res,curCnt+1);
            } 
        }

        return res;
    }

    private boolean isValid(String subStr, int maxLetters){
        int[] alpha = new int[26];
        int cnt = 0;
        for(char c : subStr.toCharArray()){
            if( alpha[c-'a'] == 0){
                alpha[c-'a']++;
                cnt++;
            }
        }
        return cnt<=maxLetters;
    }
    


    



    @Test
    public void test(){
        assertEquals(2, maxFreq("aababcaabab", 2, 3, 4));
    }
}
