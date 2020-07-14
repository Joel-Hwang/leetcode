import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public LongestSubstring() {
        this.lengthOfLongestSubstring("abcabcbb");
        System.out.println("");
        this.lengthOfLongestSubstring("abba");
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int curLength = 0;
        int result = 0;
        for (int i = 1; i <= s.length(); i++) {
            char a = s.charAt(i-1);
            if(map.containsKey(a)){
                int oldCur = curLength;
                curLength = i - map.get(a);
                curLength = curLength>oldCur+1?oldCur+1:curLength;
            }else{
                curLength++;
            }
            result = Math.max(result, curLength);
            map.put(a, i);
            System.out.println(a +" "+curLength+" " + result);
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}