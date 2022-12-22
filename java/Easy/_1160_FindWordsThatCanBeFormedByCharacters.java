package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _1160_FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] alphaMap = new int[26];
        for(char c : chars.toCharArray()) alphaMap[c-'a']++;

        for(String word : words){
            if(isMatch(word,alphaMap)) res += word.length();
        }
        return res;
    }

    private boolean isMatch(String word, int[] alphaMap){
        int[] betaMap = new int[26];
        for(char c : word.toCharArray()) betaMap[c-'a']++;

        for(int i = 0; i<alphaMap.length; i++){
            if(alphaMap[i] < betaMap[i]) return false;
        }
        return true;
    }

    @Test
    public void test(){
        assertEquals(6, countCharacters(new String[]{"cat","bt","hat","tree"}, "atach"));
    }
}
