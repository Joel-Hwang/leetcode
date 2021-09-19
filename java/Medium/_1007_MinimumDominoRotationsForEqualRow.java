package Medium;

import org.testng.annotations.Test;

public class _1007_MinimumDominoRotationsForEqualRow{
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[][] map = new int[7][4];
        int n = tops.length;
        int sum = n*(n+1)/2;
        int res = n;
        for(int i = 0; i<n; i++){
            map[tops[i]][0]++;
            map[tops[i]][1]++;
            map[bottoms[i]][0]++;
            map[bottoms[i]][2]++;

            map[tops[i]][3]+=(i+1);
            if(tops[i] != bottoms[i]) map[bottoms[i]][3]+=(i+1);
        }

        for(int i = 1; i<map.length; i++){
            if(map[i][0] >= tops.length && map[i][3] >= sum){
                int cur = Math.min( tops.length-map[i][1], tops.length-map[i][2] );
                res = Math.min(res,cur);
            }
        }
        
        return res==n?-1:res;
    }

    public int minDominoRotations2(int[] A, int[] B){
        int[] cntA = new int[7], cntB = new int[7], same = new int[7];
        int n = A.length;
        for(int i = 0; i<n; i++){
            cntA[A[i]]++;
            cntB[B[i]]++;
            if(A[i] == B[i]) same[A[i]]++;
        }

        for(int i = 1; i<7; i++){
            if(cntA[i] + cntB[i] - same[i] == n){
                return n - Math.max(cntA[i], cntB[i]);
            }
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(minDominoRotations2(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
        System.out.println(minDominoRotations2(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));
    }
}