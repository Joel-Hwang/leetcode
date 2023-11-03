package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import org.testng.annotations.Test;

public class _632_SmallestRangeCoveringElementsFromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = {-100000, 100000};
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
        int max = -100000;
        for(int i = 0; i < nums.size(); i++){
            int[] elem = {nums.get(i).get(0),0,i};
            pq.add(elem);
            max = Math.max(max, nums.get(i).get(0));
        }

        while(true){
            int[] elem = pq.poll();
            if(res[1]-res[0] > max-elem[0]){
                res[0] = elem[0];
                res[1] = max;
            }

            if(elem[1]+1==nums.get(elem[2]).size()){
                break;
            }else{
                elem[1]++;
                elem[0] = nums.get(elem[2]).get(elem[1]);
                max = Math.max(max, elem[0]);
                pq.add(elem);
            }
        }

        return res;
    }

    @Test
    public void test(){
        List<Integer> a = Arrays.asList(4,10,15,24,26);
        List<Integer> b = Arrays.asList(0,9,12,20);
        List<Integer> c = Arrays.asList(5,18,22,30);
        List<List<Integer>> d = new ArrayList<>();
        d.add(a);
        d.add(b);
        d.add(c);
        System.out.println(smallestRange(d));
    }
}
