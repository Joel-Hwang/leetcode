package Easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.testng.annotations.Test;

public class _703_KthLargestElementinaStream {
    class KthLargest {
        List<Integer> list = new ArrayList<Integer>();
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            for(int n : nums){
                insert(n);
            }
        }
        
        public int add(int val) {
            insert(val);
            return list.get(list.size()-k).intValue();
        }

        private void insert(int n){
            int l = 0, r = list.size()-1;
            while(l<=r){
                int mid = (l+r)/2;
                if(n > list.get(mid)){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
            list.add(l, n);
        }
    }

    class KthLargest2 {
        private int k;
        private PriorityQueue<Integer> heap;
        
        public KthLargest2(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>();
            
            for (int num: nums) {
                heap.offer(num);
            }
            
            while (heap.size() > k) {
                heap.poll();
            }
        }
        
        public int add(int val) {
            heap.offer(val);
            if (heap.size() > k) {
                heap.poll();
            }
    
            return heap.peek();
        }
    }

    @Test
    public void test(){
        KthLargest ans = new KthLargest(3,new int[]{4,5,8,2});
        assertEquals(4, ans.add(3));
        assertEquals(5, ans.add(5));
        assertEquals(5, ans.add(10));
        assertEquals(8, ans.add(9));
        assertEquals(8, ans.add(4));
    }

    
    
}
