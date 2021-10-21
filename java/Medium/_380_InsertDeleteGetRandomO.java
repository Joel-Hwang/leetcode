package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

public class _380_InsertDeleteGetRandomO{
    class RandomizedSet {
        ArrayList<Integer> list;
        HashMap<Integer, Integer> map;
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }
        
        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            map.put(val,list.size());
            list.add(val);
            return true;
        }
        
        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;

            int idx = map.get(val);
            if(idx<list.size()-1){
                list.set(idx, list.get(list.size()-1));
                map.put(list.get(list.size()-1), idx);
            }

            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }
        
        public int getRandom() {
            Random sr = new Random();
            int idx = Math.abs(sr.nextInt())%list.size();
            int val = list.get(idx);
            return val;
        }
    }


    @Test
    public void test(){
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(0));
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(2));
        System.out.println(obj.remove(1));
        System.out.println(obj.getRandom());
    }
}