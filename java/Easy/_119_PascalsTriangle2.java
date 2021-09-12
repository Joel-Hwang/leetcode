package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class _119_PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> prev = new ArrayList();
        prev.add(1);
        for (int i = 1; i <= rowIndex+1; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1)
                    row.add(1);
                else
                    row.add(prev.get(j - 1) + prev.get(j));
            }

            prev = row;
            if (i == rowIndex+1)
                return row;
        }
        return prev;
    }


    @Test
    public void test(){
        System.out.println(Arrays.toString(getRow(0).toArray()));
        System.out.println(Arrays.toString(getRow(1).toArray()));
        System.out.println(Arrays.toString(getRow(2).toArray()));
        System.out.println(Arrays.toString(getRow(3).toArray()));
        System.out.println(Arrays.toString(getRow(4).toArray()));
    }
}
