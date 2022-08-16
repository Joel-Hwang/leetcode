package Hard;

import java.util.*;

import org.testng.annotations.Test;


public class _1157_OnlineMajorityElementInSubarray {
    class MajorityChecker {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Map<Integer, PriorityQueue<int[]>> heap = new HashMap<>();
        public MajorityChecker(int[] arr) {
            map.put(0, new HashMap<Integer,Integer>());
            heap.put(0, new PriorityQueue<int[]>((int[] a, int[] b)->{return b[1] - a[1];}));

            map.get(0).put(arr[0], 1);
            heap.get(0).add(new int[]{arr[0],1});
            
            for(int i = 1; i<arr.length; i++){
                map.put(i, new HashMap<Integer,Integer>(map.get(i-1)));
                Map<Integer, Integer> rowMap = map.get(i);
                rowMap.put(arr[i], rowMap.getOrDefault(arr[i],0)+1);
                
                heap.put(i, new PriorityQueue<int[]>((int[] a, int[] b)->{return b[1] - a[1];}));
                for(int key : rowMap.keySet())
                    heap.get(i).add(new int[]{key,rowMap.get(key)});
            }
        }
        
        public int query(int left, int right, int threshold) {
            Map<Integer,Integer> mapLeft = map.getOrDefault(left-1,new HashMap<Integer,Integer>());

            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(heap.get(right));
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                if(cur[1] < threshold) return -1;
                if(cur[1] - mapLeft.getOrDefault(cur[0],0) >= threshold) return cur[0];
            }

            return -1;
        }

    }

    @Test
    public void test(){
        MajorityChecker test = new MajorityChecker(new int[]{1,1,2,2,1,1});
        System.out.println(test.query(0, 5, 4));
        System.out.println(test.query(0, 3, 3));
        System.out.println(test.query(2, 3, 2));
    }
}
