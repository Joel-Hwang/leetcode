package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _406_QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        int[][] result = new int[people.length][2];
        initArray(result,-1);
        for(int i = 0; i < people.length; i++){
            int position = getPosition(result, people[i][1]);
            result[position][0] = people[i][0];
            result[position][1] = people[i][1];
        }

        return result; 
    }

    private void initArray(int[][] result, int value){
        for(int i = 0; i<result.length; i++)
            for(int j = 0; j<result[i].length; j++)
                result[i][j] = value;
    }

    private int getPosition(int[][] result, int index){
        int emptyCount = 0;
        for(int i = 0; i<result.length; i++){
            if(result[i][0] == -1) emptyCount++;
            if(emptyCount > index) return i;
        }
        return -1;
    }
    
    @Test
    public void test(){
        int[][] input = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(input);
    }
}
