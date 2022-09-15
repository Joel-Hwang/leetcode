package Medium;

import java.util.*;

import org.testng.annotations.Test;

public class _2007_FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(changed);
        for(int change:changed) map.put(change, map.getOrDefault(change, 0)+1);
        
        for(int i = 0; i<changed.length; i++){
            int change = changed[i];
            if(i>0 && changed[i-1] == change) continue;
            if(change == 0) continue;
            if(map.get(change) <=0) continue;
            if( map.get(change) > map.getOrDefault(change*2,0)  ) return new int[]{};
            map.put(change*2, map.get(change*2) - map.get(change)); 
        }
        List<Integer> res = new ArrayList<>();
        if(map.getOrDefault(0, 0)%2 == 1) return new int[]{};
        for(int i = 0; i<map.getOrDefault(0,0)/2; i++) res.add(0);

        for(int key : map.keySet()){
            if(key == 0) continue;
            for(int i = 0; i<map.get(key); i++)
                res.add(key);
        }
        
        return res.stream().mapToInt(i->i).toArray();
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(findOriginalArray(new int[]{2,1,2,4,2,4})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{0,0,0,0})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{6,3,0,1})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1,3,4,2,6,8})));
    }
}
