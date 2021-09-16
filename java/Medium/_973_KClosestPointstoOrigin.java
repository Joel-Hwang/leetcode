package Medium;

import java.util.Arrays;
import java.util.Comparator;

import org.testng.annotations.Test;

public class _973_KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int k) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                int d1 = o1[0] * o1[0] + o1[1] * o1[1];
                int d2 = o2[0] * o2[0] + o2[1] * o2[1];
                return d1 - d2;
            }
        });

        //Arrays.sort(points,(p1, p2)-> p1[0]*p1[0]+p1[1]*p1[1] - p2[0]*p2[0]+p2[1]*p2[1]);
        int[][] res = new int[k][2];
        for(int i = 0; i<res.length; i++){
            res[i] = points[i];
        }
        return res;
    }

    public int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }

    @Test
    public void test(){
        int[][] aa = kClosest(new int[][]{{1,3},{-2,2}}, 1);
        System.out.println(aa);
        aa = kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2);
        System.out.println(aa);
    }
}
