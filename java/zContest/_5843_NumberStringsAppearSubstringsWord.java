package zContest;

import org.testng.annotations.Test;

public class _5843_NumberStringsAppearSubstringsWord{
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for(String s : patterns){
            if(word.contains(s)) res++;
        }
        return res;
    } 

    @Test
    public void test(){
        System.out.println(numOfStrings(new String[]{"a","abc","bc","d"}, "abc"));
        System.out.println(numOfStrings(new String[]{"a","b","c"}, "aaaaabbbbb"));
        System.out.println(numOfStrings(new String[]{"a","a","a"}, "ab"));
    }
}