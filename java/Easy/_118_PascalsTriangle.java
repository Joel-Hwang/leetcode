package Easy;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 1; i<=numRows; i++){
            List<Integer> row = new ArrayList<>();
            
            for(int j = 0; j<i; j++){
                if(j==0 || j==i-1) row.add(1);
                else row.add(res.get(res.size()-1).get(j-1) + res.get(res.size()-1).get(j)  );
            }
            res.add(row);
        }
        return res;
    }
}
