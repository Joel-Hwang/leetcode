package Easy;
import java.util.*;
public class _933_NumberOfRecentCalls {
    class RecentCounter {
        ArrayList<Integer> arr = null;
        public RecentCounter() {
            arr = new ArrayList<>();
        }
        
        public int ping(int t) {
            arr.add(t);
            int res = 0;
            for(int i = arr.size()-1; i>=0; i--){
                if( arr.get(i) >= t-3000) res++;  
            }
            return res;
        }
    }
}
