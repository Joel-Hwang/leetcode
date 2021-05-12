package Easy;

import java.util.HashMap;
import java.util.Iterator;

public class _997_FindTheTownJudge {
    public _997_FindTheTownJudge(){
        int[][] trust0 = {{3,2},{4,1},{3,1},{2,1},{2,3},{4,3},{4,2},{3,4}};
        int[][] trust1 = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int[][] trust2 = {{1,3},{2,3},{3,1}};
        int[][] trust3 = {{1,2},{2,1}};
        int[][] trust4 = {{1,2},{3,2},{1,3},{4,5},{5,2},{1,4},{2,3},{4,3},{5,1},{2,5},{4,1},{5,3}};
        System.out.println(findJudge(4,trust0));
        System.out.println(findJudge(4,trust1));
        System.out.println(findJudge(3,trust2));
        System.out.println(findJudge(2,trust3));
        System.out.println(findJudge(5,trust4));
    }

    
    public int findJudge(int N, int[][] trust) {
        if(trust.length == 0){
            if(N == 1 ) return 1;
            else return -1;
        }
        HashMap<Integer, Integer> dic = new HashMap<>();

        for(int[] tr : trust){
            dic.put(tr[1], dic.containsKey(tr[1])?dic.get(tr[1])+1:1);
        }
        for(int[] tr : trust){
            dic.remove(tr[0]);
        }
        
       

        Iterator<Integer> it = dic.keySet().iterator();
        while(it.hasNext()){
            int judge = it.next();
            if(dic.get(judge) == N-1) return judge;
        }

        return -1;
    }
}

/*
public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
*/