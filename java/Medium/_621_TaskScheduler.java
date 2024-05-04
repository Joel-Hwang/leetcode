package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _621_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c: tasks) {
            arr[c - 'A']++;
        }
        Arrays.sort(arr);
        int max = arr[25] - 1;
        int idle = max * n;
        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(max, arr[i]);
        }
        return idle > 0 ? idle + tasks.length : tasks.length;
    }

    public int leastInterval2(char[] tasks, int n) {
        int lengthOfScheduler = 0;
        int[][] frequencies = new int[26][2];
        
        for(char task: tasks)
            frequencies[task-'A'][0]++;
        for(int i = 0; i<frequencies.length; i++)
            frequencies[i][1] = -100;

        for(int i = 0; i<tasks.length; i++){
            int optimalTask = getOptimalTask(frequencies, n, lengthOfScheduler);
            
            if(optimalTask == -1 ){
                lengthOfScheduler++;
                i--;
                continue;
            }

            if(optimalTask == -2 ) break;

            frequencies[optimalTask][0]--;
            frequencies[optimalTask][1] = lengthOfScheduler;
            lengthOfScheduler++;
        }

        return lengthOfScheduler;
    }

    public int getOptimalTask(int[][] frequencies, int coolingTime, int current){
        int maxFrequency = 0;
        int thatIdx = -1;
        boolean allZero = true;
        for(int i = 0; i<frequencies.length; i++){
            int frequency = frequencies[i][0];
            int lastExecuted = frequencies[i][1];
            if(frequency > 0) allZero = false;
            if(lastExecuted + coolingTime >= current) continue;

            if(maxFrequency < frequency){
                maxFrequency = frequency;
                thatIdx = i;
            }
        }
        if(allZero) return -2;
        return thatIdx;
    }

    @Test
    public void test(){
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        System.out.println(leastInterval(new char[]{'A','C','A','B','D','B'}, 1));
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 3));
    }
}
