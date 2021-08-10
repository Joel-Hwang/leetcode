package Hard;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class _352_DataStreamDisjointIntervals {
    class SummaryRanges {
        ArrayList<Integer> dt;

        public SummaryRanges() {
            dt = new ArrayList<>();
        }

      /* Runtime: 85 ms, faster than 19.45%  
      public void addNum(int val) {
            for (int i = 0; i < dt.size(); i++) {
                if (dt.get(i) > val) {
                    dt.add(i, val);
                    return;
                }else if(dt.get(i) == val){
                    return;
                }else;
            }
            dt.add(val);
        }*/

        public void addNum(int val) {
            int l = 0, r = dt.size()-1;
            while(l<=r){
                int mid = (l+r)/2;
                if(dt.get(mid) == val) return;
                if(dt.get(mid) < val){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }

            dt.add(l,val);
        }

        public int[][] getIntervals() {
            if (dt.size() == 0)
                return null;

            ArrayList<int[]> row = new ArrayList<>();
            int start = dt.get(0);
            for (int i = 1; i < dt.size(); i++) {
                int prev = dt.get(i - 1);
                int cur = dt.get(i);
                if (cur == prev + 1) {

                } else {
                    row.add(new int[] { start, prev });
                    start = dt.get(i);
                }
            }

            row.add(new int[]{start,dt.get(dt.size()-1)});

            int[][] res = new int[row.size()][2];
            for (int i = 0; i < row.size(); i++) {
                res[i] = row.get(i);
            }
            return res;
        }
    }

    @Test
    public void test() {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1); // arr = [1]
        summaryRanges.getIntervals(); // return [[1, 1]]
        summaryRanges.addNum(3); // arr = [1, 3]
        summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
        summaryRanges.addNum(7); // arr = [1, 3, 7]
        summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
        summaryRanges.addNum(2); // arr = [1, 2, 3, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
        summaryRanges.addNum(6); // arr = [1, 2, 3, 6, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
    }
}
