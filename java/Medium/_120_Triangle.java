package Medium;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class _120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = 1; i<triangle.size(); i++){
            List<Integer> prev = triangle.get(i-1);
            List<Integer> row = triangle.get(i);
            for(int j = 0; j<row.size(); j++){
                row.set(j, row.get(j) + Math.min(j>=prev.size()?prev.get(j-1):prev.get(j), prev.get(j-1<0?0:j-1)));
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i<triangle.get(triangle.size()-1).size(); i++){
            res = Math.min(triangle.get(triangle.size()-1).get(i),res);
        }

        return res;
    }

    @Test
    public void test(){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        List<Integer> r3 = new ArrayList<>();
        List<Integer> r4 = new ArrayList<>();
        r1.add(2);
        r2.add(3);
        r2.add(4);
        r3.add(6);
        r3.add(5);
        r3.add(7);
        r4.add(4);
        r4.add(1);
        r4.add(8);
        r4.add(3);
        list.add(r1);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        System.out.println(minimumTotal(list));
        

        
    }
}
