package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _42_TrappingRainWater {
    public int trap(int[] height) {
        int[][] walls = new int[height.length][2];
        int mL=0,mR=0,res=0;
        for(int i = 0, j=height.length-1; i<height.length && j>=0; i++,j--){
            mL = Math.max(height[i], mL);
            mR = Math.max(height[j], mR);
            walls[i][0] = mL;
            walls[j][1] = mR; 
        }

        for(int i = 0; i<height.length; i++){
            res = res + Math.min(walls[i][0], walls[i][1]) - height[i];  
        }

        return res;
    }

    @Test
    public void test(){
        assertEquals(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6);
        assertEquals(trap(new int[]{4,2,0,3,2,5}), 9);
    }
}
