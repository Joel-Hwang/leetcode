package Easy;
import java.util.*;

import org.testng.annotations.Test;

public class _819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph
        .replaceAll("\\!", " ")
        .replaceAll("\\?", " ")
        .replaceAll("\\'", " ")
        .replaceAll("\\,", " ")
        .replaceAll("\\;", " ")
        .replaceAll("\\.", " ");
        Set<String> set = new HashSet<>();
        Map<String,Integer> map = new HashMap<>();
        for(String ban : banned) set.add(ban.toLowerCase());

        String[] ps = paragraph.split(" ");
        for(String p : ps){
            if(p.isEmpty()) continue;
            if(set.contains(p)) continue;
            map.put(p, map.getOrDefault(p, 0)+1);
        }

        int curFrequency = 0;
        String result = "";
        for(String key: map.keySet()){
            if(map.get(key) >= curFrequency){
                curFrequency = map.get(key);
                result = key;
            }
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}
