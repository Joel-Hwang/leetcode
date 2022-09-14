package Medium;

import java.util.*;

import org.testng.annotations.Test;

public class _967_NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            dfs(list,i,n-1,k);
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    private void dfs( List<Integer> list,int p, int n, int k ){
      if(n == 0) {
        list.add(p);
        return;
      } 

      int cur = p%10;
      int[] nexts = getNexts(cur, k);
      for(int next : nexts){
        dfs(list,p*10+next,n-1,k);
      }
      return;
    }

    private int[] getNexts(int i, int k){
      if(k==0) return new int[]{i};
        int plus = -1, minus = -1;
        if( i + k <= 9 ) plus = i+k;
        if( i - k >= 0 ) minus = i-k;

        if(plus >=0 && minus >=0) return new int[]{minus,plus};
        if(plus >=0 ) return new int[]{plus};
        if(minus >=0 ) return new int[]{minus};
        return new int[]{};
    }

    @Test
    public void test(){
      System.out.println(Arrays.toString(numsSameConsecDiff(2, 0)));
      System.out.println(Arrays.toString(numsSameConsecDiff(3, 7)));
    }
}
