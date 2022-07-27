package Medium;

import java.util.Arrays;
import java.util.Comparator;

import org.testng.annotations.Test;

public class _1996_TheNumberOfWeakCharactersInTheGame {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(int[] a, int[] b) -> { 
            if (a[0] == b[0]) 
                return b[1] - a[1];
            return a[0] - b[0];
        });
        
        int max = properties[properties.length - 1][1];
        int res = 0;
        for(int i  = properties.length-2; i >= 0; i--) {
            if(properties[i][1] < max ) res++;
            else max = properties[i][1];
        }

        return res;
    }

    public int numberOfWeakCharacters2(int[][] properties) {
        int res = 0;
        Arrays.sort(properties, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ?
                Integer.compare(o2[1], o1[1]) : Integer.compare(o1[0], o2[0]));
        int len = properties.length;
        int max = properties[len-1][1];
        for (int i=len-2; i>=0; i--) {
            if (properties[i][1] < max) {
                res ++;
            } else {
                max = properties[i][1];
            }
        }
        return res;
    }
    

    @Test
    public void test(){
        System.out.println(numberOfWeakCharacters(new int[][]{{1,1},{2,1},{2,2},{1,2}}));
    }
}
