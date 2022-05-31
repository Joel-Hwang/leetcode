package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _1889_MinimumSpaceWastedFromPackaging {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        long res = -1;
        sortAll(packages, boxes);

        for(int[] box : boxes){
            long curSpace = getWastedSpace(packages, box);
            if(curSpace < 0) continue;
            res = res<0?curSpace:Math.min(res,curSpace);
        }
        return (int)(res%1000000007);
    }

    private void sortAll(int[] packages, int[][] boxes){
        Arrays.sort(packages);

        for(int[] box : boxes) Arrays.sort(box);

        Arrays.sort(boxes,(a,b) -> {
            return a[a.length-1] - b[b.length-1];
        });
    }
    
    private long getWastedSpace(int[] packages, int[] boxes){
        if(packages[packages.length-1] > boxes[boxes.length-1]) return -1;
        long res = 0;
        int pkgCursor = 0;
        int boxCursor = 0;
        while(pkgCursor < packages.length && boxCursor < boxes.length){
            if(packages[pkgCursor] <= boxes[boxCursor]){
                res += boxes[boxCursor] - packages[pkgCursor];
                pkgCursor++;
            }else{
                boxCursor++;
            }
            
        } 
        return res;
    }

    @Test
    public void test(){
        assertEquals(6,minWastedSpace(new int[]{2,3,5}, new int[][]{{4,8},{2,8}}));
    }
}
