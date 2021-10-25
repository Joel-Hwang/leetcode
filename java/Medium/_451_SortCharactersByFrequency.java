package Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class _451_SortCharactersByFrequency {
    public String frequencySort2(String s) {
        int[][] freq = new int[80][2];
        char[] arC = s.toCharArray();
        for(int i = 0; i<arC.length; i++){
            char c = arC[i];
            freq[c-'0'][0]++;
            freq[c-'0'][1] = c;
        }

        Arrays.sort(freq, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i2[0] - i1[0];
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int[] ar : freq){
            for(int i = 0; i<ar[0]; i++){
                sb.append((char)ar[1]);
            }
        }

        return sb.toString();
    }


    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
		// put every char with it frequency in the map
        s.chars().forEach(c -> map.put((char) c, map.getOrDefault((char) c, 0) + 1));
        return map.entrySet()
                .stream()
				// sort by value in desc order
                .sorted(Map.Entry.comparingByValue((o1, o2) -> -o1.compareTo(o2))) 
				// get char repeated by its frequency
                .map(entry -> String.valueOf(entry.getKey()).repeat(entry.getValue())) 
                .map(String::valueOf)
                .collect(Collectors.joining()); 
    }

    @Test
    public void test(){
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }
}
