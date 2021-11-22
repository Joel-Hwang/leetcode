package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class _187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<10) return new ArrayList();
        Set<String> set = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for(int i = 0; i<=s.length()-10; i++){
            String dna = s.substring(i, i+10);
            if(!set.add(dna) ){
                seen.add(dna);
            }
        }
        return new ArrayList(seen);
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> res = new ArrayList();
        if(s.length()<10) return res;
        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i<=s.length()-10; i++){
            String dna = s.substring(i, i+10);
            map.put(dna, map.getOrDefault(dna, 0)+1);
        }


        for(String key : map.keySet()){
            if(map.get(key) > 1) res.add(key);
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(findRepeatedDnaSequences("AAAAAAAAAAA").toArray()));
        System.out.println(Arrays.toString(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toArray()));
    }
}
