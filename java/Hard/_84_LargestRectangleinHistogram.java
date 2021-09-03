package Hard;

import org.testng.annotations.Test;

public class _84_LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        for(int l = 0, r = heights.length-1; l<heights.length && r>=0; l++,r--){
            int c = l-1;
            int d = r+1;
            if(c>=0 && heights[c] >= heights[l]){
                left[l] = left[c];
            }else{
                left[l] = l;
            }

            if(d<heights.length && heights[d] >= heights[r]){
                right[r] = right[d];
            }else{
                right[r] = r;
            }
        }


        for(int i = 0; i<heights.length; i++){
            res = Math.max(res,heights[i]*(right[i]-left[i]+1));
        }

        return res;
    }
    public int largestRectangleArea2(int[] heights) {
        int res = 0;
        int idxS = 0;
        int idxE = 0;
        int minVal = Integer.MAX_VALUE;
        int[] minHeight = new int[heights.length];
        for(int i = 0; i<heights.length; i++){
            minHeight[i] = heights[i];
            for(int j = 0; j <= i; j++){
                minHeight[j] = Math.min(minHeight[j], heights[i]);
                if(idxS<=j && j<=idxE) minHeight[j] = Math.min(minHeight[j],minVal);

                int curSize = (i-j+1)*minHeight[j];
                res = Math.max(res,curSize);
                
                if(minHeight[j] >= heights[i]){
                    idxS = j;
                    idxE = i;
                    minVal = heights[i];
                    break;
                } 
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(largestRectangleArea(new int[]{4,2,0,3,2,4,3,4}));
        System.out.println(largestRectangleArea(new int[]{9,9}));
        System.out.println(largestRectangleArea(new int[]{0,1,0,1}));
        System.out.println(largestRectangleArea(new int[]{0,9}));
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
/*

2 : 2
1 : 2, 1
5 : 3, 2, 5
6 : 4, 3, 10, 6
2 : 5, 4, 6, 4, 2 
3 : 6, 5, 8, 6, 4, 3

*/