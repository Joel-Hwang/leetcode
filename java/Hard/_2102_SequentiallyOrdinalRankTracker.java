package Hard;

import java.util.ArrayList;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class _2102_SequentiallyOrdinalRankTracker {
    class SORTracker {
        TreeSet<Key> treeSet;
        Key lastReturned = new Key("", Integer.MAX_VALUE);
        public SORTracker() {
            treeSet = new TreeSet<>();
        }
        
        public void add(String name, int score) {
            Key current = new Key(name, score);
            treeSet.add(current);
            if(current.compareTo(lastReturned) < 0) 
                lastReturned = treeSet.lower(lastReturned);
        }
        
        public String get() {
            lastReturned = treeSet.higher(lastReturned);
            return lastReturned.name;
        }

        class Key implements Comparable<Key>{
            public String name;
            public int score;
            public Key(String name, int score){
                this.name = name;
                this.score = score;
            }

            @Override
            public int compareTo(Key o) {
                if(this.score != o.score) return Integer.compare(o.score, this.score);
                return this.name.compareTo(o.name);
            }
        }
    }


    class SORTracker2 {

    ArrayList<Key> list = null;
        int cnt = 0;
        public SORTracker2() {
            list = new ArrayList<Key>();
        }
        
        public void add(String name, int score) {
            Key key = new Key(name, score);
            int index = findIndex(key);
            list.add(index, key);
        }
        
        public String get() {
            return list.get(cnt++).name;
        }

        private int findIndex(Key key){
            int l = 0, r = list.size();
          
            while(l < r){
                int mid = (l+r)/2;
                if(compare(key, list.get(mid))){
                    r = mid;
                }else{
                    l = mid+1;
                }
            }
            return l;
        }

        private boolean compare(Key k1, Key k2){
            if(k1.score == k2.score){
                return k1.name.compareTo(k2.name)<0;
            }
            return k1.score>k2.score;
        }


        class Key{
            public String name;
            public int score;
            public Key(String name, int score){
                this.name = name;
                this.score = score;
            }
        }
}
    @Test
    public void test(){
        SORTracker obj = new SORTracker();
        obj.add("bradford", 2);
        obj.add("branford", 3);
        obj.add("alps", 2);
        obj.add("orland", 2);
        obj.add("orlando", 3);
        obj.add("alpine", 2);
        obj.get();
        obj.get();
        obj.get();
        obj.get();
        obj.get();

    }
}
