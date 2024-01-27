package Hard;

import java.util.*;

import org.testng.annotations.Test;

public class _2251_NumberOfFlowersInFullBloom {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] result = new int[people.length];
        int[][] peopleWithIndex = new int[people.length][2];
        for(int i = 0; i<peopleWithIndex.length; i++){
            peopleWithIndex[i][0] = people[i];
            peopleWithIndex[i][1] = i;
        }
        Arrays.sort(flowers,(a,b)->a[0]-b[0]);
        Arrays.sort(peopleWithIndex, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> minHeapOfEndtime = new PriorityQueue<>();

        int idxFlower = 0;
        for(int i = 0; i<peopleWithIndex.length; i++){
            int time = peopleWithIndex[i][0];
            int idxPeople = peopleWithIndex[i][1];

            while(idxFlower < flowers.length && flowers[idxFlower][0] <= time){
                minHeapOfEndtime.add(flowers[idxFlower][1]);
                idxFlower++;
            }

            while(minHeapOfEndtime.isEmpty() == false && minHeapOfEndtime.peek() < time){
                minHeapOfEndtime.poll();
            }
            result[idxPeople] = minHeapOfEndtime.size();

        }
        return result;
        
    }
    

    @Test
    public void test() {
        
        System.out.println(Arrays.toString(fullBloomFlowers(new int[][] { { 1, 6 }, { 3, 7 }, { 9, 12 }, { 4, 13 } }, new int[] { 2, 3, 7, 11 })));
        System.out.println(Arrays.toString(fullBloomFlowers(new int[][] { { 1, 10 }, { 3, 3 } }, new int[] { 3, 3, 2 })));
        System.out.println(Arrays.toString(fullBloomFlowers(new int[][] { { 21,34 }, { 17, 37 },{ 23, 43 }, { 17, 46 }, { 37, 41 }, { 44, 45 }, { 32, 45 } }, new int[] { 31,41,10,12 })));
    }
}
