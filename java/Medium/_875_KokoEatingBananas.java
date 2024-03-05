package Medium;

import org.testng.annotations.Test;

public class _875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0, r = 0;
        for(int p : piles) r = Math.max(r,p);

        while(l<r){
            int mid = l + (r-l)/2;
            int hour = getHour(piles, mid);
            if(hour > h){
                l = mid+1;
            }else{
                r = mid;
            }
        }

        for(int i = l-1; i>=1; i--){
            if( getHour(piles, i) > h )
                return i+1;
        }

        return -1;
    }


    private int getHour(int[] piles, int k){
        int hour = 0;
        for(int p: piles){
           hour += Math.ceil((double)p/k);
        }
        return hour;
    }

    @Test
    public void test(){
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
}
