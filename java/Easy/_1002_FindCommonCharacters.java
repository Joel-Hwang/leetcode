package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class _1002_FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        int[][] dic = new int[words.length][26];
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i<words.length; i++){
            char[] arWord = words[i].toCharArray();
            for(char c : arWord){
                dic[i][c-'a']++;
            }
        }

        for(int i = 0; i<26; i++){
            int cnt = Integer.MAX_VALUE;
            for(int j = 0; j<dic.length; j++){
                cnt = Math.min(cnt, dic[j][i]);
            }

            for(int k = 0; k<cnt; k++){
                res.add((char)(i+'a')+"");
            }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(commonChars(new String[]{"bella","label","roller"}).toArray() ));
    }
}
