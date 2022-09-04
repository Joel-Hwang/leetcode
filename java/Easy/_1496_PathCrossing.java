package Easy;

import java.util.*;

import org.testng.annotations.Test;

public class _1496_PathCrossing {
    public boolean isPathCrossing(String path) {
        char[] paths = path.toCharArray();
        Set<String> points = new HashSet<>();
        points.add("0,0");
        int x = 0;
        int y = 0;
        for(char way : paths){
            switch (way){
                case 'N':
                y++;
                break;
                case 'S':
                y--;
                break;
                case 'W':
                x--;
                break;
                case 'E':
                x++;
                break;
            }
            if(points.contains(x+","+y)) return true;
            points.add(x+","+y);
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(isPathCrossing("NES"));
    }
}
