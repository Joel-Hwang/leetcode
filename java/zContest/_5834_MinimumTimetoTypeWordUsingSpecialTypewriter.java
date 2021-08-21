package zContest;

import org.testng.annotations.Test;

public class _5834_MinimumTimetoTypeWordUsingSpecialTypewriter {
    public int minTimeToType(String word) {
        int res = 0;
        char[] words = word.toCharArray();
        char cur = 'a';
        for(char c : words){
            int dist = c-cur;
            if(dist<0) dist+=26;
            if(dist > 13) dist = 26-dist;

            res += dist+1;
            cur = c;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(minTimeToType("a"));
        System.out.println(minTimeToType("zjpc"));
        System.out.println(minTimeToType("abc"));
        System.out.println(minTimeToType("bza"));
    }
}
