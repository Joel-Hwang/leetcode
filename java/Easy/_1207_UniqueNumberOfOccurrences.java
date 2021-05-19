package Easy;
import java.util.HashMap;
import java.util.Iterator;

public class _1207_UniqueNumberOfOccurrences {
    public _1207_UniqueNumberOfOccurrences(){
        int[] a = {1,2,2,1,1,3};
        int[] a1 = {1,2};
        System.out.println(uniqueOccurrences(a));
        System.out.println(uniqueOccurrences(a1));
    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> rMap = new HashMap<>();
        for(int a : arr){
            map.put(a, map.getOrDefault(a,0)+1);
        }

        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()){
            int key = it.next();
            if(rMap.containsKey(map.get(key))) return false;
            rMap.put(map.get(key),key);
        }
        return true;
    }
}
