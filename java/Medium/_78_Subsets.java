package Medium;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class _78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        for(int i = 1; i<=nums.length; i++){
            combination2(nums,0,i,new ArrayList<Integer>(),res);
        }
        return res;
    }



    public void combination2(int[] ar,int start, int pick, List<Integer> parent, List<List<Integer>> res){
        if( pick < 1){
            res.add(new ArrayList<>(parent));
            return;
        }
        for(int i = start; i<ar.length-(pick-1); i++){
            parent.add(ar[i]);
            combination2(ar,i+1, pick-1, parent, res);
            parent.remove(parent.size()-1);
        }
    }


    @Test
    public void test(){
        List<List<Integer>> a = subsets(new int[]{0});
        for(List<Integer> r : a){
            for(Integer c : r){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
