package Hard;

import java.util.LinkedList;
import java.util.List;

/*
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.

The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:

lefti is the x coordinate of the left edge of the ith building.
righti is the x coordinate of the right edge of the ith building.
heighti is the height of the ith building.
You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form 
[[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline 
except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's 
termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings 
should be part of the skyline's contour.

Note: There must be no consecutive horizontal lines of equal height in the output skyline. 
For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; 
the three lines of height 5 should be merged into one 
in the final output as such: [...,[2 3],[4 5],[12 7],...]

스카이라인은 빌딩들의 실루엣에 의한 윤곽으로 이루어진다. 빌딩의 위치와 높이가 주어지고
이는 buildings[i] = [left, right, height] 형태이다.
left는 i 빌딩의 왼쪽 코너 x좌표이다.
right는 i 빌딩의 오른쪽 커너 x좌표이다.
height는 빌딩의 높이다.
짐작했다시비 모든 빌딩은 사각형이며 지면은 평지로 높이가 0이다.
스카이라인은 x좌표로 정렬된 key point 리스트로 구성될 수 있다.
각 키 포인트는 스카이라인의 왼쪽 엔드포인트로 구성되고 
마지막 포인트는 오른쪽 끝을 나타낸다. 가장 왼쪽과 가장 오른쪽 빌딩 사이의 땅들도 스카이라인에 포함된다.

Example1
Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
Explanation:
Figure A shows the buildings of the input.
Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.

Example 2:

Input: buildings = [[0,2,3],[2,5,3]]
Output: [[0,3],[5,0]]-

*/
public class _218_The_Skyline_Problem {

    public _218_The_Skyline_Problem(){
        List<List<Integer>> r1 = getSkyline(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}});
        List<List<Integer>> r2 = getSkyline(new int[][]{{0,2,3},{1,5,3}});
        List<List<Integer>> r3 = getSkyline(new int[][]{{1,2,1},{1,2,2},{1,2,3}});
        printList(r1);
        printList(r2);
        printList(r3);
    
    }
    public void printList(List<List<Integer>> l){
        for(List<Integer> r : l){
            System.out.println(r.get(0)+"," + r.get(1));
        }
        System.out.println("==========end=========");
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new LinkedList<>();
        int l = 0, r = 1, h = 2;
        LinkedList<Integer> raw0 = new LinkedList<>();
        raw0.add(buildings[0][l]);
        raw0.add(buildings[0][h]);
        res.add(raw0);
        //System.out.println(buildings[0][l]+", "+buildings[0][h]);
        
        for(int i = 1; i<buildings.length; i++){
            int[] pbd = buildings[i-1];
            int[] bd = buildings[i];

            if(pbd[r] < bd[l]){
                LinkedList<Integer> raw = new LinkedList<>();
                raw.add(pbd[r]);
                raw.add(0);
                res.add(raw);
                //System.out.println(pbd[r]+", 0");
            }

            //겹치는 빌딩 부분
            if(bd[h] < pbd[h] && pbd[l] <= bd[l] && bd[l] <= pbd[r] ){
                LinkedList<Integer> raw = new LinkedList<>();
                raw.add(pbd[r]);
                raw.add(bd[h]);
                res.add(raw);
                //System.out.println(pbd[r]+", "+bd[h]);
            //오른쪽 땅
            }else if(bd[h] == pbd[h] && pbd[l] <= bd[l] && bd[l] <= pbd[r] ){
                continue;
            }else{
                LinkedList<Integer> raw = new LinkedList<>();
                raw.add(bd[l]);
                raw.add(bd[h]);
                res.add(raw);
                //System.out.println(bd[l]+", "+bd[h]);
            } 
        }
        LinkedList<Integer> raw1 = new LinkedList<>();
        raw1.add(buildings[buildings.length-1][r]);
        raw1.add(0);
        res.add(raw1);
        //System.out.println(buildings[buildings.length-1][r]+", 0");
        return res;
    }
}
