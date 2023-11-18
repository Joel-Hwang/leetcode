package Easy;

import org.testng.annotations.Test;

public class _1897_RedistributeCharactersToMakeAllStringsEqual{
    public boolean makeEqual(String[] words) {
        int[] frequencies = new int[26];
        for(String word: words){
            for(char character : word.toCharArray())
                frequencies[character-'a']++;
        }

        for(int frequency: frequencies){
            if(frequency % words.length != 0) return false;
        }
        return true;

    }

    @Test
    public void test(){
        System.out.println(makeEqual(new String[]{"abc","aabc","bc"}));
        System.out.println(makeEqual(new String[]{"ab","a"}));
    }
}