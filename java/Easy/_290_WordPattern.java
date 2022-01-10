package Easy;

import java.util.HashMap;

import org.testng.annotations.Test;

public class _290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> map1 = new HashMap<>();
        HashMap<Character,String> map2 = new HashMap<>();
        String[] arS = s.split("\\s+");
        if(arS.length != pattern.length()) return false;

        for(int i = 0; i<arS.length; i++){
            if(map1.containsKey(arS[i])){
                if(map1.get(arS[i]) != pattern.charAt(i)) return false;
            }else{
                map1.put(arS[i], pattern.charAt(i));
            }

            if(map2.containsKey(pattern.charAt(i))){
                if(!map2.get(pattern.charAt(i)).equals(arS[i])) return false;
            }else{
                map2.put(pattern.charAt(i),arS[i]);
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
    }
}