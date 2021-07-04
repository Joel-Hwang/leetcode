package Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
        List<List<Integer>> r2 = getSkyline(new int[][]{{0,2,3},{1,5,3}});
        List<List<Integer>> r3 = getSkyline(new int[][]{{1,2,1},{1,2,2},{1,2,3}});
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
        int l=0,r=1,h=2;
        List<List<Integer>> res = new LinkedList<>();
        List<List<Integer>> m = new LinkedList<>();
        
        int[] p = buildings[0];
        m.add(setList(p[l],p[h]));
        m.add(setList(p[r],0));
        for(int[] b : buildings){
            if( b[l] <= p[r] && p[r] < b[r] ){
                if(p[h] > b[h]){
                    m.set(m.size()-1,setList(p[r],b[h]));
                    m.add(setList(b[r],0));
                }else if(p[h] < b[h]){
                    if(b[l] == p[l]){ //p의 l이 b의 l과 같고 b의 높이가 높아서 p의 좌꼭 무시
                        m.set(m.size()-2,setList(b[l],b[h]));    
                        m.add(setList(b[r],0));
                    }else{
                        m.set(m.size()-1,setList(b[l],b[h]));
                        m.add(setList(b[r],0));
                    }
                }else{
                    m.set(m.size()-1,setList(b[r],0));
                }
            }else if(p[l] < b[l] && b[r] < p[r]){
                if(p[h] < b[h]){ //b가 p 안에 포함되는데 더 높은 경우. 나머지 케이스는 변동 없음
                    m.set(m.size()-1,setList(b[l],b[h]));
                    m.add(setList(b[r],p[h]));
                    m.add(setList(p[r],0));
                }
            }else if(p[l] == b[l] && b[r] < p[r]){
                if(p[h] < b[h]){ //b의 l이 p의 l과 같고 더 높은 경우. 나머지 케이스는 변동 없음
                    m.set(m.size()-2,setList(b[l],b[h]));
                    m.set(m.size()-1,setList(b[r],p[h]));
                    m.add(setList(p[r],0));
                }
            }else if(p[l] < b[l] && b[r] == p[r]){
                if(p[h] < b[h]){ //b의 l이 p의 l과 같고 더 높은 경우. 나머지 케이스는 변동 없음
                    m.set(m.size()-1,setList(b[l],b[h]));
                    m.add(setList(p[r],0));
                }
            }else if(p[l] == b[l] && b[r] == p[r]){ //p와b의 l,r이 일치
                if(p[h] < b[h]){ // 더 높은 경우. 나머지 케이스는 변동 없음
                    m.set(m.size()-1,setList(b[l],b[h]));
                    m.add(setList(p[r],0));
                }
            }else{//두 건물이 떨어진 경우
                m.add(setList(b[l],b[h]));
                m.add(setList(b[r],0));
                
            }
            addToRes(res,b[l],m);
            p=b;
            printList(m);
        }
        //세번째 건물로 인해서 2개 이상의 마크가 소실될수 있는 경우 고려 안함
        //m을 순환하면서 새로운 마크보다 밑에 있는 애들은 지워야 함
        //m을 순환하는 시간이 걸리니까 res에 l보다 작은거 꾸준히 넣으면서 시작

        return res;
    }
    public List<Integer> setList(int x, int y){
        List<Integer> res = new LinkedList<>();
        res.add(x);
        res.add(y);
        return res;
    }
    public void addToRes( List<List<Integer>> res, int l, List<List<Integer>> m ){
        for(List<Integer> row : m){
            if(row.get(0) < l){
                res.add(row);
                m.remove(row);
            }else{
                break;
            }
        }
    }



    public List<int[]> getSkyline2(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
                if(a[0] != b[0]) 
                    return a[0] - b[0];
                return a[1] - b[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for(int[] h:height) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}
