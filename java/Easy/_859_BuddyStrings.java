package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class _859_BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int[] alphabets = new int[26];

        char[] c1 = new char[2];
        char[] c2 = new char[2];
        int cursor = -1;
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i)-'a']++;
            alphabets[goal.charAt(i)-'a']++;

            if(s.charAt(i) != goal.charAt(i)){
                cursor++;
                if(cursor>1) return false;
                c1[cursor] = s.charAt(i);
                c2[cursor] = goal.charAt(i);
            }
        }

        if (s.equals(goal)){
            for(int i = 0; i<alphabets.length; i++){
                if(alphabets[i] > 3) return true;
            }
            return false;
        }
        return c1[0] == c2[1] && c1[1] == c2[0];
    }

    public boolean buddyStrings2(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            Set<Character> s = new HashSet<Character>();
            for (char c : A.toCharArray()) s.add(c);
            return s.size() < A.length();
        }
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) if (A.charAt(i) != B.charAt(i)) dif.add(i);
        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }
    @Test
    public void test(){
        assertEquals(true, buddyStrings("dd","dd"));
        assertEquals(true, buddyStrings("abab","abab"));
        assertEquals(true, buddyStrings("ab","ba"));
        assertEquals(false, buddyStrings("ab","ab"));
        assertEquals(true, buddyStrings("aa","aa"));
    }
}
