package Medium;

import java.util.*;

import org.testng.annotations.Test;
public class _1997_FirstDayWhereYouHaveBeenInAlltheRooms {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        Map<Integer, Integer> visited = new HashMap<>();
        int result = 1;
        int lastVisit = 0;
        visited.put(0, 1);
        while(visited.size() < nextVisit.length){
            if(visited.get(lastVisit)%2==1)
                lastVisit = nextVisit[lastVisit];
            else
                lastVisit = (lastVisit+1)%nextVisit.length;
            
            System.out.println(lastVisit);
            visited.put(lastVisit, (visited.getOrDefault(lastVisit, 0)+1)%2);
            result++;
        }
        
        return result-1;
    }
    @Test
    public void test(){
        System.out.println(firstDayBeenInAllRooms(new int[]{0,0,0}));
    }
}
