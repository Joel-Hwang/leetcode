package Medium;

import java.util.ArrayList;
import java.util.List;

class _77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        int[] ar = new int[n];
        for(int i = 0; i<n; i++) ar[i] = i+1;

        List<List<Integer>> res = new ArrayList<>();
        combination2(ar,0,k,new ArrayList<Integer>(),res);
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
}

