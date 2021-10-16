package Medium;

import java.util.HashSet;
import java.util.Set;

public class _208_ImplementTrie {
    class Trie {
        Set<String> set;
        public Trie() {
            set = new HashSet<>();
        }
        
        public void insert(String word) {
            set.add(word);
        }
        
        public boolean search(String word) {
            return set.contains(word);
        }
        
        public boolean startsWith(String prefix) {
            for(String key : set){
                if(key.startsWith(prefix)) return true;
            }
            return false;
        }
    }
}
