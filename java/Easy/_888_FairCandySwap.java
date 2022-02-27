package Easy;

import java.util.*;

import org.testng.annotations.Test;

public class _888_FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int asum = 0;
        Set<Integer> aSet = new HashSet<>(); 
        Set<Integer> bSet = new HashSet<>(); 
        for(int candy : aliceSizes){
            asum+=candy;
            aSet.add(candy);
        }

        int bsum = 0;
        for(int candy : bobSizes){
            bsum+=candy;
            bSet.add(candy);
        }

        int avg = (asum+bsum)/2;
        for(int key : aSet){
            //asum-key+x = avg;
            if(bSet.contains(avg - asum + key)){
                return new int[]{key,avg - asum + key};
            }
        }

        return null;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1,2}, new int[]{2,3})));
        System.out.println(Arrays.toString(fairCandySwap(new int[]{2}, new int[]{1,3})));
    }
}