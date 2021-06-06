package Medium;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class _39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> cands = new ArrayList<Integer>();
        for(int cand : candidates){
            int div = target/cand;
            for(int i = 1; i<=div; i++){
                cands.add(cand);
            }
        }

        combination(cands,0,2,new ArrayList<Integer>(),target,res);

        return res;
    }

    public void combination(List<Integer> ar,int start, int pick, List<Integer> parent,int target, List<List<Integer>> res){
        if( pick < 1){
            int sum = 0;
            for(int v : parent){
                sum +=v;
            }
            
            if (sum == target) res.add(parent);
            return;
        }

        for(int i = start; i<ar.size()-(pick-1); i++){
            parent.add(ar.get(i));
            combination(ar,i+1, pick-1, parent, target, res);
        }
    }

    @Test
    public void test(){
        combinationSum(new int[]{2,3,6,7},5);

    }
}

//   combination(new int[]{2,3,6,7},0,2, "");