package Easy;

import org.testng.annotations.Test;

public class _1189_MaximumNumberBalloons {
    public int maxNumberOfBalloons(String text) {
        //"balloon"  b 1개, a 1개, l 2개, o 2개, n 1개
        int[] dic = new int[26];
        for(char c : text.toCharArray()){
            dic[c-'a']++;
        }

        int res = text.length();
        res = Math.min(dic['b'-'a'],res);
        res = Math.min(dic['a'-'a'],res);
        res = Math.min(dic['l'-'a']/2,res);
        res = Math.min(dic['o'-'a']/2,res);
        res = Math.min(dic['n'-'a'],res);
        return res;
    }

    @Test
    public void test(){
        System.out.println(maxNumberOfBalloons("leetcode"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("nlaebolko"));
    }
}
