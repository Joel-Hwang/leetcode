package Hard;

import org.testng.annotations.Test;

public class _84_LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] minHeight = new int[heights.length];
        for(int i = 0; i<heights.length; i++){
            minHeight[i] = heights[i];
            for(int j = 0; j <= i; j++){
                minHeight[j] = Math.min(minHeight[j], heights[i]);
                
                int curSize = (i-j+1)*minHeight[j];
                res = Math.max(res,curSize);
                
               // if(minHeight[j] >= heights[i]) break;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(largestRectangleArea(new int[]{0,1,0,1}));
        System.out.println(largestRectangleArea(new int[]{9,9,9,9,9,9,9,9}));
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