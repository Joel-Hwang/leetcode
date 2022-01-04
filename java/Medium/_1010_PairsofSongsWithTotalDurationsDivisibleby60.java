package Medium;

import java.util.HashMap;

import org.testng.annotations.Test;

public class _1010_PairsofSongsWithTotalDurationsDivisibleby60 {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int numPairsDivisibleBy602(int[] time) {
        for(int i : time){
            map.put(i%60, map.getOrDefault(i%60, 0) + 1);
        }

        int res = 0;
        Integer[] keys = map.keySet().toArray(new Integer[map.size()]);
        for(int i = 0; i<keys.length; i++){
            for(int j = i+1; j<keys.length; j++){
                if(keys[i] + keys[j] == 60){
                    res += map.get(keys[i])*map.get(keys[j]);
                }
            }
        }
        res += permutation2(0);
        res += permutation2(30);
        return res;
    }


    private int permutation2(int n){
        int cnt = map.getOrDefault(n,0);
        return cnt*(cnt-1)/2;
    }

    public int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[60];
        for(int i : time){
            map[i%60]++;
        }

        int res = 0;
        for(int i = 0; i<=30; i++){
            if(i==0||i==30){
                res += map[i]*(map[i]-1)/2;
            }else{
                res += map[i]*map[60-i];
            }

        }

        return res;
        
    }


    @Test
    public void test(){
        System.out.println(numPairsDivisibleBy60(new int[]{60,60,60}));
        System.out.println(numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    }
}
