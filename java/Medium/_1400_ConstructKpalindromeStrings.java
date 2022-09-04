package Medium;

public class _1400_ConstructKpalindromeStrings{
    public boolean canConstruct(String s, int k) {
        int[] dic = new int[26];
        for(char c : s.toCharArray())
            dic[c-'a']++;

        int odds = 0;
        for(int c : dic){
            if(c%2==1) odds++;
        }
        return s.length() >= k && k >= odds;
    }
}