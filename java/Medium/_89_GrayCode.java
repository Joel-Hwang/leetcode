package Medium;

import java.util.LinkedList;
import java.util.List;

public class _89_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList();
        res.add(0);
        //res.add(1);
        for(int i = 0; i<n; i++){
            int size = res.size();
            for(int j = size-1; j>=0; j--){
                res.add(res.get(j)|1<<i);
            }
        }
        return res;
    }
}
