package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;


public class _40_CombinationSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combination(candidates,0,new ArrayList<Integer>() ,target,res);
        return res;
    }

    public void combination(int[] cands,int start, List<Integer> comb, int target, List<List<Integer>> res){
        if( target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }
       
        for(int i = start; i<cands.length; i++){
            if(cands[i]>target) continue;
            //첫 행은 무조건 comb에 넣고 다음행부터 중복일 경우 continue
            //1,1,6은 허용하지만 1,2,5가 2번 생기는건 막기 위함
            if(i>start && cands[i]==cands[i-1]) continue;

            comb.add(cands[i]);
            combination(cands,i+1, comb, target-cands[i], res);
            //DFS에서 마지막 요소를 제거해야 부모로 올라간 후 다음 자식으로 내려옴
            comb.remove(comb.size()-1);
        }
    }

    @Test
    public void test(){
        combinationSum2(new int[]{10,1,2,7,6,1,5},8);

    }
}
