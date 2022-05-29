package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _318_MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        int maxProd = 0;
        for(int i = 0; i<words.length-1; i++) {
            for(int j = i+1; j < words.length; j++) {
                if(words[i].length()*words[j].length() <= maxProd) continue;
                if(hasDupChar(words[i], words[j])) continue;
                maxProd = Math.max(maxProd, words[i].length()*words[j].length());
            }
        }

        return maxProd;
    }

    private boolean hasDupChar(String A, String B){
        int[] alphabets = new int[26];
        for(char a : A.toCharArray())
            alphabets[a-'a']++;
        for(char b : B.toCharArray())
            if(alphabets[b-'a']>0) return true;
        return false;
    }


    public static int maxProduct2(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
                    maxProduct = words[i].length() * words[j].length();
            }
        return maxProduct;
    }

    @Test
    public void test(){
        assertEquals(16, maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
}
