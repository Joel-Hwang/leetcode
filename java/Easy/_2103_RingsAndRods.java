package Easy;

import org.testng.annotations.Test;

public class _2103_RingsAndRods {
    public int countPoints(String rings) {
        int[][] map = new int[10][3];
        for(int i = 0; i<rings.length(); i+=2){
            int color = rings.charAt(i)=='R'?0:rings.charAt(i)=='G'?1:2;
            int pos = rings.charAt(i+1)-48;
            map[pos][color]++;
        }

        int res = 0;
        for(int i = 0; i<map.length; i++){
            if(map[i][0] > 0 && map[i][1] > 0 && map[i][2] > 0 ) res++;
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(countPoints("B0B6G0R6R0R6G9"));
    }
}
