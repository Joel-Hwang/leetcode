package Medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.testng.annotations.Test;

public class _954_ArrayDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int i : arr){
            freqMap.put(i, freqMap.getOrDefault(i, 0)+1);
        }

        for(int key : freqMap.keySet()){
            if(freqMap.get(key) == 0) continue;
            //if(freqMap.getOrDefault(key/2,0) == 0 && freqMap.getOrDefault(key*2,0)==0) return false;
            int cur = freqMap.get(key);
            if(freqMap.containsKey(key*2)){
                int curMul2 = freqMap.getOrDefault(key*2,0);
                int diff = cur-curMul2;
                freqMap.put(key, diff>=0?diff:0 );
                freqMap.put(key*2, diff>=0?0:-diff);
            }
            cur = freqMap.get(key);
            if(key%2==0 && freqMap.containsKey(key/2)){
                int curDiv2 = freqMap.getOrDefault(key/2,0);
                int diff = cur-curDiv2;
                freqMap.put(key, diff>=0?diff:0);
                freqMap.put(key/2, diff>=0?0:-diff);
            }
        }


        for(int key : freqMap.keySet()){
            if(freqMap.get(key) != 0) return false;
        }

        return true;
    }

    public boolean canReorderDoubled2(int[] A) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int a : A)
            count.put(a, count.getOrDefault(a, 0) + 1);
        for (int x : count.keySet()) {
            if (count.get(x) == 0) continue;
            int want = x < 0 ? x / 2 : x * 2;
            if (x < 0 && x % 2 != 0 || count.get(x) > count.getOrDefault(want, 0))
                return false;
            count.put(want, count.get(want) - count.get(x));
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(canReorderDoubled(new int[]{0,0}));
        System.out.println(canReorderDoubled(new int[]{3,1,3,6}));
        System.out.println(canReorderDoubled(new int[]{2,1,2,6}));
        System.out.println(canReorderDoubled(new int[]{4,-2,2,-4}));
        System.out.println(canReorderDoubled(new int[]{1,2,4,16,8,4}));
        System.out.println(canReorderDoubled(new int[]{-1,1}));
        System.out.println(canReorderDoubled(new int[]{2,4,2,4,4,8}));
    }
}
