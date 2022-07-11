package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _2047_NumberOfValidWordsInASentence {
    public int countValidWords(String sentence) {
        int res = 0;
        String[] words = sentence.split(" ");
        for(String word : words){
            if(isValid(word)) res++;
        }
        return res;
    }

    private boolean isValid(String s) {
        if("".equals(s)) return false;
        String digit = "0123456789";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int hypenCnt = 0;
        char[] arC = s.toCharArray();
        for(int i = 0; i<arC.length; i++) {
            if(digit.contains( String.valueOf(arC[i]))) return false;
            if(i != arC.length - 1 && ".!,".contains(String.valueOf(arC[i]))) return false;
            if(arC[i] == '-'){
                hypenCnt++;
                if(hypenCnt>1) return false;
                if(i==0 || i == arC.length-1) return false;
                if( alphabet.contains(String.valueOf(arC[i-1])) == false ) return false;
                if( alphabet.contains(String.valueOf(arC[i+1])) == false ) return false;
            }
        }
        return true;
    }

    public int countValidWords2(String sentence) {
        String regex = "^([a-z]+(-?[a-z]+)?)?(!|\\.|,)?$";
        String r2 = "[^0-9]+";
        String[] arr = sentence.split("\\s+");
        int ans = 0;
        for(String s: arr)
        {
            if(s.matches(regex) && s.matches(r2))
            {
                ans++;
                //System.out.println(s);
            }
        }
        return ans;
    }

    @Test
    public void test(){
        assertEquals(6, countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
        assertEquals(3, countValidWords("cat and dog"));
        assertEquals(0, countValidWords("!this  1-s b8d!"));
        assertEquals(5, countValidWords("alice and  bob are playing stone-game10"));
    }
}
