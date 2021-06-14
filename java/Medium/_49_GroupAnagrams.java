package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class _49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> m = new HashMap<>();
        for(String s : strs){
            String sortedS = sortStr(s);
            if(m.containsKey(sortedS)){
                m.get(sortedS).add(s);
            }else{
                List<String> row = new ArrayList<>();
                row.add(s);
                m.put(sortedS, row);
            }
        }

        Iterator<String> it =  m.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            res.add(m.get(key));
        }
        return res;
    }

    public String sortStr(String s){
        char[] arC = s.toCharArray();
        Arrays.sort(arC);
        return new String(arC);
    }

    @Test
    public void test(){
        List<List<String>> res = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for(List<String> row : res){
            for(String c : row){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
