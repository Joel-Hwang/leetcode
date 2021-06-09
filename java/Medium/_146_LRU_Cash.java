package Medium;

import java.util.Iterator;
import java.util.LinkedHashMap;


import org.testng.annotations.Test;

public class _146_LRU_Cash {
    public LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
    public int capa = 0;
    public _146_LRU_Cash(){
    }
    public _146_LRU_Cash(int capacity) {
        capa = capacity;
    }

    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        int res = hm.get(key);
        hm.remove(key);
        hm.put(key, res);
        return res;
    }

    public void put(int key, int value) {

        if(hm.containsKey(key)){
            hm.remove(key);
            hm.put(key, value);
            return;
        }
        
        if(hm.size()<capa){
            hm.put(key, value);
            return;
        } 

        hm.remove(hm.keySet().iterator().next());
        hm.put(key, value);
    }

    @Test
    public void test() {
        /*_146_LRU_Cash lRUCache = new _146_LRU_Cash(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1); // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2); // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1); // return -1 (not found)
        lRUCache.get(3); // return 3
        lRUCache.get(4); // return 4*/

        _146_LRU_Cash lRUCache = new _146_LRU_Cash(2);
        System.out.println(lRUCache.get(2));
        lRUCache.put(2, 6);
        System.out.println(lRUCache.get(1));
        lRUCache.put(1, 5);
        lRUCache.put(1, 2);
        System.out.println(lRUCache.get(1));
        System.out.println( lRUCache.get(2));
        
    }
}
