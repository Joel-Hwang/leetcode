package Medium;

import org.testng.annotations.Test;

public class _849_MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int lastIdx = 0;
        int firstIdx = -1;
        for(int i = 0; i<seats.length; i++){
            if(seats[i] == 1){
                if(firstIdx < 0) firstIdx = i;
                res = Math.max(res, (i-lastIdx)/2);
                lastIdx = i;
            }
        }
        
        res = Math.max(res,firstIdx);
        res = Math.max(res,seats.length-1-lastIdx);

        return res;
    }

    @Test
    public void test(){
        System.out.println(maxDistToClosest(new int[]{1,0,1}));
        System.out.println(maxDistToClosest(new int[]{0,1}));
        System.out.println(maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
        System.out.println(maxDistToClosest(new int[]{1,0,0,0}));
    }
}
