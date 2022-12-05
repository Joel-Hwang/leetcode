package Medium;

import org.testng.annotations.Test;

public class _835_ImageOverlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
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
