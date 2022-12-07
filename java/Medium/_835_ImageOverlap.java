package Medium;

import java.util.*;

import org.testng.annotations.Test;

public class _835_ImageOverlap {

    public int largestOverlap(int[][] A, int[][] B) {
        int res = 0;
        List<Integer> LA = new ArrayList<>();
        List<Integer> LB = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int n = A.length;
        for(int i = 0; i<n*n; i++) if(A[i/n][i%n] == 1) LA.add(i/n*100+i%n); 
        for(int i = 0; i<n*n; i++) if(B[i/n][i%n] == 1) LB.add(i/n*100+i%n); 

        for(int i = 0; i<LA.size(); i++)
            for(int j = 0; j<LB.size(); j++)
                count.put(LA.get(i) - LB.get(j), count.getOrDefault(LA.get(i) - LB.get(j), 0)+1);

        for(int key : count.keySet())
            res = Math.max(res, count.get(key));
        return res;
    }


    public int largestOverlap2(int[][] img1, int[][] img2) {
        int res = 0;
        for(int i = -img2.length+1; i<img2.length; i++)
            for(int j = -img2[0].length+1; j<img2[0].length; j++)
                res = Math.max(res,getOverlap(img1, img2, i, j));
        return res;
    }

    private int getOverlap(int[][] img1, int[][] img2, int y, int x){
        int res = 0;
        for(int i = 0; i<img1.length; i++)
            for(int j = 0; j<img1[0].length; j++){
                if(img1[i][j] == 1 && getValue(img2,i-y,j-x) == 1) 
                    res++;
            }
        return res;
    }

    private int getValue(int[][] img, int y,int x){
        if(x<0 || x>=img[0].length || y < 0 || y >= img.length) return 0;
        return img[y][x];
    }

    @Test
    public void test(){
        int[][] img1 = {{1,1,0},
                        {0,1,0},
                        {0,1,0}};

        int[][] img2 = {{0,0,0},
                        {0,1,1},
                        {0,0,1}};
        System.out.println(largestOverlap(img1, img2));
    }
}
