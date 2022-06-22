package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.PriorityQueue;
import java.util.Queue;

import org.testng.annotations.Test;

public class _1642_FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int res = 0;
        int sumOfBricks = 0;
        Queue<Integer> ladderHeap = new PriorityQueue<>();

        for(int i = 1; i < heights.length; i++) {
            res = i;
            if(heights[i] <= heights[i-1]) continue;

            int gap = heights[i] - heights[i-1];
            ladderHeap.add(gap);
            if(ladderHeap.size() > ladders){
                int polled = ladderHeap.poll();
                sumOfBricks += polled;
            }
            
            if(sumOfBricks > bricks) return i-1;
        }

        return res;
    }

    @Test
    public void test(){
        assertEquals(3, furthestBuilding(new int[]{14,3,19,3}, 17, 0));
        assertEquals(7, furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2));
    }
}
