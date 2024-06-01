package Easy;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class _1668_MaximumRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        int[] ar = new int[sequence.length()];
        for(int i = sequence.length()-word.length(); i >= 0; i--){
            for(int j = 0; j<word.length(); j++){
                if(sequence.charAt(i+j) != word.charAt(j)) break;
                if(j == word.length()-1) ar[i]++;
            }
        }
        
        int result = 0;
        for(int i = ar.length-1; i>=0; i--){
            if(ar[i]==0) continue;

            if(i+word.length() < ar.length)
                ar[i] += ar[i+word.length()];
            result = Math.max(result, ar[i]);    
        }

        return result;
    }

    @Test
    public void test(){
        System.out.println(maxRepeating("baba","b"));
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba","aaaba"));
        System.out.println(maxRepeating("ababc","ac"));
        System.out.println(maxRepeating("ababc","ab"));
        System.out.println(maxRepeating("ababc","ba"));
    }
}
