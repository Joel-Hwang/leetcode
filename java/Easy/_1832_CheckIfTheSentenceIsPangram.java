package Easy;

import java.util.Set;
import java.util.HashSet;

public class _1832_CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for(char c : sentence.toCharArray())
            set.add(c);
        return set.size()==26;
    }
}
