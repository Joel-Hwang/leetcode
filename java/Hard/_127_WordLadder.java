package Hard;
import java.util.*;

import org.testng.annotations.Test;

public class _127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet();
        Queue<String> q = new LinkedList();
        for(String word : wordList) set.add(word);
        q.add(beginWord);
        int depth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int idx = 0; idx<size; idx++){
                String val = q.poll();
                if(endWord.equals(val)) return depth;
    
                char[] cVal = val.toCharArray();
                for(int i = 0; i<cVal.length; i++){
                    char keepOld = cVal[i];
                    for(char alphabet = 'a'; alphabet<='z'; alphabet++){
                        if(cVal[i] == alphabet) continue;
                        cVal[i] = alphabet;
    
                        if(set.contains( String.valueOf(cVal) )){
                            set.remove(String.valueOf(cVal));
                            q.add(String.valueOf(cVal));
                        }
                    }
                    cVal[i] = keepOld;
                }
            }
            
            depth++;
        }
        return 0;
    }


    boolean isOne(String a, String b){
        int diffCnt = 0;
        for(int i = 0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) diffCnt++;
            if(diffCnt>1) break;
        }
        return diffCnt<=1;
    }

    @Test
    public void test(){
        ArrayList<String> a = new ArrayList<>();
        a.add("hot");
        a.add("dot");
        a.add("dog");
        a.add("lot");
        a.add("log");
        a.add("cog");
        System.out.println( ladderLength("hit", "cog", a )); 
    }

    
}
