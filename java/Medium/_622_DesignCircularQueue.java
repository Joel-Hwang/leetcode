package Medium;
import java.util.*;
public class _622_DesignCircularQueue {
    class MyCircularQueue {
        private List<Integer> list;
        private final int size;
        public MyCircularQueue(int k) {
            list = new ArrayList<>();
            size = k;
        }
        
        public boolean enQueue(int value) {
            if(list.size() >=size) 
                return false;
            list.add(value);
            return true;
        }
        
        public boolean deQueue() {
            if(list.size()==0) return false;
            list.remove(0);
            return true;
        }
        
        public int Front() {
            return list.isEmpty()?-1:list.getFirst();            
        }
        
        public int Rear() {
            return list.isEmpty()?-1:list.getLast();            
            
        }
        
        public boolean isEmpty() {
            return list.isEmpty();
        }
        
        public boolean isFull() {
            return list.size()==size;
        }
    }
}
