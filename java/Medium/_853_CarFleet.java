package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _853_CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for(int i = 0; i<cars.length; i++){
            double time =(target-position[i]+0.0)/speed[i];
            cars[i] = new Car();
            cars[i].position = position[i];
            cars[i].speed = speed[i];
            cars[i].time = time;
        }
        
        Arrays.sort(cars,(a,b)->Integer.compare(b.position, a.position));
    
        int res = 1;
        // 12 <-    10    8    5   3   0
        double currentTime = cars[0].time; //현재 그룹에서 가장 높은 타임 : 그룹에서 제일 느린놈.      ㅁ.ㅁ.ㅁ.ㅁ        ㅁ.ㅁ   ㅁ.ㅁ.ㅁ
        for(int i= 1; i<cars.length; i++){
            if(cars[i].time > currentTime)
                res++;
                
            currentTime = Math.max(currentTime, cars[i].time);
        }


        return res;
    }
    
    @Test
    public void test(){
        carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3});
        carFleet(100, new int[]{0,2,4}, new int[]{4,2,1});
    }
}

class Car{
    int position;
    int speed;
    double time;
}


