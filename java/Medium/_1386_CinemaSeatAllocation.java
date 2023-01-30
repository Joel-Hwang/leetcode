package Medium;
import java.util.*;

import org.testng.annotations.Test;


public class _1386_CinemaSeatAllocation{
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int i = 0; i<reservedSeats.length; i++){
            Set<Integer> curSet = map.getOrDefault(reservedSeats[i][0], new HashSet<Integer>());
            curSet.add(reservedSeats[i][1]);
            map.putIfAbsent(reservedSeats[i][0], curSet);
        }
        
        int res = n*2;
        for(int key : map.keySet())
            res += getSeats(map.get(key))-2;
        return res;
    }

    private int getSeats(Set<Integer> set){
        if( !set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5) &&
        !set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9) ) return 2;
        if( !set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5)   ) return 1;
        if( !set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7)   ) return 1;
        if( !set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9)   ) return 1;
        return 0;
    }

    @Test
    public void test(){
        System.out.println(maxNumberOfFamilies(3,new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}}));
    }



}