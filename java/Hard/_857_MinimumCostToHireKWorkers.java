package Hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import org.testng.annotations.Test;

public class _857_MinimumCostToHireKWorkers{
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[][] workers = new double[quality.length][2];
        for(int i = 0; i<quality.length; i++){
            workers[i][0] = (double)wage[i]/quality[i];
            workers[i][1] = quality[i];
        }

        Arrays.sort(workers, (a,b) -> Double.compare(a[0], b[0])  );
        int qSum = 0;
        double res = Double.MAX_VALUE;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(double[] w : workers){
            qSum += w[1];
            maxHeap.offer(w[1]);
            if(maxHeap.size() > K){
                qSum -= maxHeap.poll();
            }
            if(maxHeap.size() == K){
                res = Math.min(res,w[0]*qSum);    
            }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(mincostToHireWorkers(new int[]{10,20,5}, new int[]{70,50,30}, 2));
    }

}