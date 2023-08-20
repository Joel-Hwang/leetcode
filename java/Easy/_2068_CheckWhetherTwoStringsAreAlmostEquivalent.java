package Easy;

public class _2068_CheckWhetherTwoStringsAreAlmostEquivalent {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] frequencies = new int[26];
        for(char c : word1.toCharArray())
            frequencies[c-'a']++;
        for(char c : word2.toCharArray())
            frequencies[c-'a']--;
        
        for(int frequency : frequencies)
            if(Math.abs(frequency)>3)
                return false;
        return true;
    }
}
