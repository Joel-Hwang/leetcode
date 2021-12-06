package Hard;

import java.util.HashMap;

import org.testng.annotations.Test;

public class _1032_StreamOfCharacters {
    // Time Limit
    /*
     * class StreamChecker {
     * 
     * Set<String> set = new HashSet<>();
     * StringBuilder sb = new StringBuilder();
     * public StreamChecker(String[] words) {
     * for(String word : words) set.add(word);
     * }
     * 
     * public boolean query(char letter) {
     * sb.append(letter);
     * for(String key : set){
     * if(sb.toString().endsWith(key)) return true;
     * }
     * return false;
     * }
     * }
     */

    class StreamChecker {
        StringBuilder sb = new StringBuilder();
        Tree root;
        public StreamChecker(String[] words) {
            root = new Tree();
            for (String word : words){
                Tree parent = root;
                for(int i = word.length()-1; i>=0; i--){
                    char c = word.charAt(i);
                    Tree cur = new Tree(c, i==0);
                    if(parent.child.get(c) == null){
                        parent.child.put(c,cur);
                        parent = cur;
                    }else{
                        parent = parent.child.get(c);
                        if(i==0) parent.isEnd = true;
                    }
                }
            }
        }

        public boolean query(char letter) {
            sb.append(letter);
            Tree parent = root;
            int idx = 1;
            Tree cur = null;
            do{
                if(idx > sb.length()) return false;
                cur = parent.child.get(sb.charAt(sb.length()-(idx++)));
                if(cur == null) return false;
                if(cur.isEnd) return true;
                parent = cur;
            }while(cur != null);

            return false;
        }

        class Tree{
            char value;
            boolean isEnd = false;
            HashMap<Character,Tree> child;
            public Tree(){
                child = new HashMap<>();
            }
            public Tree(char value, boolean isEnd){
                this();
                this.value = value;
                this.isEnd = isEnd;
            }
            public boolean isLeaf(){
                return child.size() == 0;
            }
        }
    }

    @Test
    public void test() {
        StreamChecker sc = new StreamChecker(new String[] {});
        String query = "";
        char[] arC = query.toCharArray();

        sc = new StreamChecker(new String[] {  "abaa","abaab","aabbb","bab","ab" });
        query = "aabbbaabbaaaababbbabbbaaaaababbbaabbbaba";
        arC = query.toCharArray();
        for (char c : arC) {
            System.out.println(sc.query(c));
        }

/*
        sc = new StreamChecker(new String[] {  "ab","ba","aaab","abab","baa" });
        query = "aaaaabababbbababbbbababaaabaaa";
        arC = query.toCharArray();
        for (char c : arC) {
            System.out.println(sc.query(c));
        }


        sc = new StreamChecker(new String[] { "abab", "baba", "abba" });
        query = "abababba";
        arC = query.toCharArray();
        for (char c : arC) {
            System.out.println(sc.query(c));
        }*/


    }
}
