package Easy;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _1103_DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int rotate = (int)((Math.sqrt(1+8l*candies)-1)/2);
        int leftover = candies - rotate*(rotate+1)/2;

        int howManyTimes = rotate/num_people;
        for(int i = 1; i<=result.length; i++){
            if(i-1 > rotate-howManyTimes*num_people){
                result[i-1] = howManyTimes*((howManyTimes-1)*num_people+2*i)/2;
                
            }else if(i-1 == rotate-howManyTimes*num_people){
                result[i-1] = howManyTimes*((howManyTimes-1)*num_people+2*i)/2 + leftover;
            }else{
                result[i-1] = (howManyTimes+1)*(howManyTimes*num_people+2*i)/2;
            }
        }

        return result;    
    }


    @Test
    public void test(){
        System.out.println(Arrays.toString(distributeCandies(1000000000, 1000)));
        System.out.println(Arrays.toString(distributeCandies(10, 3)));
        System.out.println(Arrays.toString(distributeCandies(7, 4)));
    }
}
