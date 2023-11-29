package Easy;

import org.testng.annotations.Test;

public class _748_ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase().replaceAll(" ", "");
        
        int[] licensePlateMap = new int[26];
        for(char c : licensePlate.toCharArray()){
            if('0'<=c && c<='9')continue;
            licensePlateMap[c-'a']++;
        } 

        String result = "aaaaaaaaaaaaaaaaaaaa";
        first: for(String word : words){
            int[] currentWordMap = new int[26];
            for(char c : word.toCharArray()) currentWordMap[c-'a']++;
            
            for(int i = 0; i<26; i++){
                if(licensePlateMap[i]>1 && licensePlateMap[i] != currentWordMap[i] ) continue first;
                if(licensePlateMap[i]>currentWordMap[i]) continue first;
            }
            
            if(word.length() < result.length()) result = word;
            
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(shortestCompletingWord("1s3 PSt", new String[]{"step","steps","stripe","stepple"}));
    }
}
