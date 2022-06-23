package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class _820_ShortEncodingOfWords {
    
    public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie(0,' ', null);
        Trie cur = root;
        for(String word : words){
            cur = root;
            for(int i = word.length()-1; i>=0; i--){
                if(cur.children.containsKey( word.charAt(i) ) == false){
                    Trie node = new Trie(cur.depth+1,word.charAt(i), null);
                    cur.children.put(word.charAt(i), node);
                }
                cur = cur.children.get( word.charAt(i) );
            }
        }

        List<Integer> sizes = new ArrayList<>();
        getDepth(root, sizes);

        int res = 0;
        for(int size : sizes){
            res += size;
        }

        return res+sizes.size();
    }

    public void getDepth(Trie node, List<Integer> res){
        if(node.children.size() == 0) res.add(node.depth);
        for(char c : node.children.keySet()){
            getDepth(node.children.get(c), res);
        }
    }

    class Trie{
        public char val;
        public int depth;
        public Map<Character,Trie> children;
        public Trie(int depth, char val, Map<Character,Trie> children){
            this.depth = depth;
            this.val = val;
            this.children = children==null?new HashMap<>():children;
        }
    }

    @Test
    public void test(){
        assertEquals(5, minimumLengthEncoding(new String[]{"me","time"}));
        assertEquals(2, minimumLengthEncoding(new String[]{"t"}));
        assertEquals(10, minimumLengthEncoding(new String[]{"time","me","bell"}));
    }
}
