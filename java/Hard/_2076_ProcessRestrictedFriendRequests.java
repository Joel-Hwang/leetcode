package Hard;
import java.util.*;

import org.testng.annotations.Test;
public class _2076_ProcessRestrictedFriendRequests {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        boolean[] res = new boolean[requests.length];
        Map<Integer, Set<Integer>> restrictionsMap = new HashMap<>();
        Map<Integer, Set<Integer>> allowMap = new HashMap<>();
        setBlockMap(restrictionsMap,restrictions, n);
        setAllowMap(allowMap,n);

        for(int i = 0; i<requests.length; i++){
            res[i] = canBeFriend(requests[i][0], requests[i][1], restrictionsMap, allowMap);
        }

        return res;
    }
    private boolean canBeFriend(int a, int b, Map<Integer, Set<Integer>> restrictionsMap, Map<Integer, Set<Integer>> allowMap){
        if(isInRestrictionList(a,b,restrictionsMap, allowMap)) return false;

        shareAllowMap(a,b,allowMap);
        shareRestrictionMap(a,b,restrictionsMap, allowMap );

        return true;
    }
    private boolean isInRestrictionList(int a, int b, Map<Integer, Set<Integer>> restrictionsMap, Map<Integer, Set<Integer>> allowMap){
        for(int friendWithB :  allowMap.get(b)){
            if(restrictionsMap.get(a).contains(friendWithB)){
                restrictionsMap.get(a).add(b);
                restrictionsMap.get(b).add(a);
                return true;
            } 
        } 
        
        for(int friendWithA :  allowMap.get(a)){
            if(restrictionsMap.get(b).contains(friendWithA)){
                restrictionsMap.get(a).add(b);
                restrictionsMap.get(b).add(a);
                return true;
            }
        } 
        return false;
    }

    private void setBlockMap(Map<Integer, Set<Integer>> restrictionsMap, int[][] restrictions, int n){
        for(int i = 0; i<n; i++)
            restrictionsMap.put(i, new HashSet<>());
        

        for(int i = 0; i<restrictions.length; i++){
            Set<Integer> set = restrictionsMap.get(restrictions[i][0]);
            if(set.size() == 0)
                restrictionsMap.put(restrictions[i][0], set);
            set.add(restrictions[i][1]);

            Set<Integer> set2 = restrictionsMap.get(restrictions[i][1]);
            if(set2.size() == 0)
                restrictionsMap.put(restrictions[i][1], set2);
            set2.add(restrictions[i][0]);
        }
    }

    private void setAllowMap(Map<Integer, Set<Integer>> allowMap, int n){
        for(int i = 0; i<n; i++){
            Set<Integer> set = new HashSet<>();
            set.add(i);
            allowMap.put(i, set);
        }
    }

    private void shareRestrictionMap(int a, int b, Map<Integer, Set<Integer>> restrictionsMap, Map<Integer, Set<Integer>> allowMap){
        Set<Integer> setA = restrictionsMap.get(a);
        Set<Integer> setB = restrictionsMap.get(b);
        if(setA == setB) return;
        setA.addAll(setB);
        for(int frindWitB : allowMap.get(b))
            restrictionsMap.put(frindWitB, setA);
    }
    
    private void shareAllowMap(int a, int b, Map<Integer, Set<Integer>> allowMap){
        Set<Integer> setA = allowMap.get(a);
        Set<Integer> setB = allowMap.get(b);
        if(setA == setB) return;
        setA.addAll(setB);
        for(int frindWitB : allowMap.get(b))
            allowMap.put(frindWitB, setA);
    }

    private void printMap(int n, Map<Integer, Set<Integer>> map){
        for(int i = 0; i<n; i++)
            System.out.println(i+": "+map.get(i));
    }
    @Test
    public void test(){
        System.out.println(Arrays.toString(friendRequests(18, new int[][]{{14,2},{1,8},{4,5},{16,6},{10,8},{10,3},{17,14},{13,2},{5,1},{0,4},{8,12},{6,5},{7,9},{12,16},{17,16},{15,11},{5,7},{9,16},{14,7},{7,8},{2,7},{3,5},{9,13},{10,13},{2,3},{2,17},{12,3},{9,10},{15,4},{11,13},{13,7},{7,1},{13,6},{10,11},{10,17},{11,2},{7,17},{0,10},{15,1},{9,3},{1,11},{11,0},{7,6},{8,0},{6,15},{0,13},{9,15},{5,11},{6,12},{17,15},{2,12},{15,0},{4,7},{16,5},{9,5},{4,3},{12,5},{1,2},{13,5},{10,7},{12,15},{11,17},{12,0},{9,14},{17,12},{4,6},{13,15},{4,10},{11,7},{8,5},{5,17},{8,3},{15,7},{13,12},{9,0},{17,3},{11,8},{8,16},{2,16},{4,12},{3,1},{8,14},{15,3},{14,11},{6,0},{12,7},{0,2},{0,7},{5,14},{8,2},{13,17},{17,8},{4,13},{1,0},{7,16},{5,2},{9,11},{12,9},{16,3},{5,15},{2,15},{3,6},{17,9},{4,16},{4,2}}
        , new int[][]{{12,0},{4,7},{9,0},{4,5},{4,6},{0,16},{2,15},{1,2},{12,15},{16,6},{13,3},{2,12},{12,15},{9,15},{2,16},{1,8},{12,5},{2,16},{14,13},{9,13},{3,1},{13,16},{8,13},{9,16},{5,2},{4,14},{9,10},{6,5},{5,7},{12,3},{8,2},{12,0},{0,17},{12,16},{9,15},{4,3},{11,7},{4,13},{4,6},{10,13},{14,12},{15,0},{9,6},{4,10},{7,8},{4,3},{10,17},{4,10},{1,2},{11,12},{6,5},{5,2},{9,10},{14,7},{17,15},{2,17},{11,0},{14,0},{14,11},{15,7},{13,6},{4,14},{0,4},{17,3},{11,17},{8,12},{6,11},{3,11},{17,15},{17,16},{4,5},{12,7},{0,17},{15,11},{0,4},{10,16},{15,7},{14,12},{1,6},{11,13},{10,13},{0,5},{1,0},{10,11},{2,17},{1,11},{13,2},{0,5},{12,7},{17,14},{12,9},{0,17},{15,10},{5,2},{16,6},{0,13},{17,6},{1,11},{13,17},{11,8},{0,16},{13,17},{6,11},{0,7},{13,12},{11,16},{8,13},{17,6},{8,13},{9,8},{9,0},{17,16},{4,13}})));
        System.out.println(Arrays.toString(friendRequests(5, new int[][]{{0,1},{1,2},{2,3}}, new int[][]{{0,4},{1,2},{3,1},{3,4}})));
        System.out.println(Arrays.toString(friendRequests(3, new int[][]{{0,1}}, new int[][]{{0,2},{2,1}})));
    }
}
