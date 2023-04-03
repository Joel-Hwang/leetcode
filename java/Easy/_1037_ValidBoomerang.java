package Easy;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _1037_ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        if(isSame(points[0], points[1])) return false;
        if(isSame(points[1], points[2])) return false;
        if(isSame(points[0], points[2])) return false;
        Arrays.sort(points, (a,b)-> { 
            if(a[0] == b[0])
                return a[1] - b[1];   
            return a[0] - b[0];
        } );

        int[] distances = {
            getDistance(points[0],points[1]),
            getDistance(points[1],points[2]),
            getDistance(points[0],points[2])
        };

        System.out.println(distances[0] +" "+ distances[1]+" "+distances[2]);
        return Math.abs((distances[0]+distances[1]) - distances[2])>1;
    }

    private boolean isSame(int[] p1, int[] p2){
        return p1[0]==p2[0] && p1[1]==p2[1];
    }
    private int getDistance(int[] p1, int[] p2){
        return (int)(Math.sqrt(Math.pow(p2[1]-p1[1], 2) + Math.pow(p2[0]-p1[0], 2))*10000000);
    }

    public boolean isBoomerang2(int[][] p) {
        return (p[1][0]-p[0][0])*(p[2][1]-p[1][1]) != (p[2][0]-p[1][0])*(p[1][1]-p[0][1]);
    }

    @Test
    public void test(){
        System.out.println(isBoomerang2(new int[][]{{2,2},{4,4},{14,14}}));
        System.out.println(isBoomerang2(new int[][]{{52,28},{23,63},{46,67}}));
    }
}
