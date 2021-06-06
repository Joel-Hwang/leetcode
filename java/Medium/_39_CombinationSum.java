package Medium;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class _39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            comb.add(cands[i]);
            combination(cands,i, comb, target-cands[i], res);
            //DFS에서 마지막 요소를 제거해야 부모로 올라간 후 다음 자식으로 내려옴
            comb.remove(comb.size()-1);
        }
    }

    @Test
    public void test(){
        combinationSum(new int[]{2,3,6,7},7);

    }
}

//   combination(new int[]{2,3,6,7},0,2, "");