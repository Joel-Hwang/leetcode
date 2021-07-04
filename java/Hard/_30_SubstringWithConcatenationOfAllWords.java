package Hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _30_SubstringWithConcatenationOfAllWords {
    public _30_SubstringWithConcatenationOfAllWords(){
        //List<Integer> aa = findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",new String[]{"fooo","barr","wing","ding","wing"});
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        Arrays.sort(words);
        int wordLen = words[0].length();
        int wordsFullLen = words.length*wordLen;
        for(int i = 0; i<=s.length()-wordsFullLen; i++){
            String[] subAr = orderedArray(s.substring(i, i+wordsFullLen), wordLen);
            if(isSame(subAr,words)){
                res.add(i);
            }
        }
        return res;
    }

    private String[] orderedArray(String s, int len){
        String[] ar = new String[s.length()/len];
        for(int i = 0; i<ar.length; i++){
            ar[i] = s.substring(i*len, i*len + len);
        }
        Arrays.sort(ar);
        return ar;
    }

    private boolean isSame(String[] a, String[] b){
        if(a.length != b.length) return false;
        boolean res = true;
        for(int i = 0; i<a.length; i++){
            if(!a[i].equals(b[i])) return false;
        }
        return res;
    }
}