package Medium;

import java.util.*;

import org.testng.annotations.Test;

public class _1146_SnapshotArray {
    class SnapshotArray {

        List<Map<Integer,Integer>> snapshot;
        Map<Integer,Integer> currentDiff;
        public SnapshotArray(int length) {
            snapshot  = new ArrayList<>();
            currentDiff = new HashMap<>();
        }
        
        public void set(int index, int val) {
            currentDiff.put(index, val);
        }
        
        public int snap() {
            snapshot.add(currentDiff);
            currentDiff = new HashMap<>();
            return snapshot.size()-1;
        }
        
        public int get(int index, int snap_id) {
            for(int i = snap_id; i>=0; i--)
                if(snapshot.get(i).containsKey(index))
                    return snapshot.get(i).get(index);
            
            return 0;
        }   
    }

    class SnapshotArray2 {

        TreeMap<Integer, Integer>[] snapshotArray;
        int snap_id;
       
        public SnapshotArray2(int length) {
            this.snapshotArray = new TreeMap[length];
            this.snap_id = 0;
            for (int i = 0; i < length; i++) {
                snapshotArray[i] = new TreeMap<>();
                snapshotArray[i].put(0, 0);
            }
        }
       
        public void set(int index, int val) {
            snapshotArray[index].put(snap_id, val);
        }
       
        public int snap() {
            return snap_id++;
        }
       
        public int get(int index, int snap_id) {
            return snapshotArray[index].floorEntry(snap_id).getValue();
        }
       }

    @Test
    public void test(){
        SnapshotArray ar = new SnapshotArray(1);
        ar.set(0, 15);
        System.out.println(ar.snap());
        System.out.println(ar.snap());
        System.out.println(ar.snap());
        System.out.println(ar.get(0, 2));
        System.out.println(ar.snap());
        System.out.println(ar.snap());
        System.out.println(ar.get(0, 0));
    }

    

    
}
