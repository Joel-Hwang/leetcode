package Medium;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class _46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutation2(nums,0,4, new ArrayList<Integer>(), res);
        return res;
    }


    public void permutation2(int[] ar,int start, int pick, List<Integer> parent, List<List<Integer>> res){
        if( pick < 1){
            res.add(new ArrayList<>(parent));
            return;
        }

        for(int i = start; i<ar.length; i++){
            parent.add(ar[i]);
            swap(ar,parent.size()-1,i);
            permutation2(ar,start+1,pick-1,parent,res);
            swap(ar,i,parent.size()-1);
            parent.remove(parent.size()-1);
        }
    }

    public void swap(int[] ar, int a, int b){
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }


    public List<List<Integer>> permute2(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length ==0) return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i< num.length; ++i){
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>(); 
            for (int j = 0; j<=i; ++j){            
               for (List<Integer> l : ans){
                   List<Integer> new_l = new ArrayList<Integer>(l);
                   new_l.add(j,num[i]);
                   new_ans.add(new_l);
               }
            }
            ans = new_ans;
        }
        return ans;
    }

    @Test
    public void test(){
        List<List<Integer>> res = permute(new int[]{1,2,3,4});
        for(List<Integer> row : res){
            for(Integer c : row){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
