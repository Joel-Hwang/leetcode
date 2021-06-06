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

        combination(cands,0,1,"",target,res);
        combination(cands,0,2,"",target,res);
        combination(cands,0,3,"",target,res);
        combination(cands,0,4,"",target,res);

        return res;
    }

    public void combination(List<Integer> ar,int start, int pick, String parent,int target, List<List<Integer>> res){
        if( pick < 1){
            int sum = 0;
            for(char c : parent.toCharArray()){
                sum += (c-'0');
            }
            
            if (sum == target) {
                List<Integer> a = new ArrayList();
                for(char c : parent.toCharArray()){
                    a.add(c-'0');
                }
                res.add(a);
            }
            return;
        }
       
        for(int i = start; i<ar.size()-(pick-1); i++){
            combination(ar,i+1, pick-1, parent+ar.get(i), target, res);
        }
    }

    @Test
    public void test(){
        combinationSum(new int[]{2,3,6,7},5);

    }
}

//   combination(new int[]{2,3,6,7},0,2, "");