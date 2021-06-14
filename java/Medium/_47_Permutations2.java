package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class _47_Permutations2{
    public List<List<Integer>> permuteUnique(int[] nums) {
    
        List<List<Integer>> res = new ArrayList<>();
        HashMap<List<Integer>,Boolean> uniq = new HashMap<>();
        permutation2(nums,0,nums.length, new ArrayList<Integer>(), res,uniq);
        return res;
    }


    public void permutation2(int[] ar,int start, int pick, List<Integer> parent, List<List<Integer>> res, HashMap<List<Integer>,Boolean> uniq){
        if( pick < 1){
            if(!uniq.containsKey(parent)){
                res.add(new ArrayList<>(parent));
                uniq.put(parent,true);
            }
            return;
        }

        for(int i = start; i<ar.length; i++){
            parent.add(ar[i]);
            swap(ar,parent.size()-1,i);
            permutation2(ar,start+1,pick-1,parent,res,uniq);
            swap(ar,i,parent.size()-1);
            parent.remove(parent.size()-1);
        }
    }

    public void swap(int[] ar, int a, int b){
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }

    @Test
    public void test(){
        List<List<Integer>> res = permuteUnique(new int[]{1,1,2});
        for(List<Integer> row : res){
            for(Integer c : row){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}

//Solution
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        // count the occurrence of each number
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num))
                counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        LinkedList<Integer> comb = new LinkedList<>();
        this.backtrack(comb, nums.length, counter, results);
        return results;
    }

    protected void backtrack(
            LinkedList<Integer> comb,
            Integer N,
            HashMap<Integer, Integer> counter,
            List<List<Integer>> results) {

        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0)
                continue;
            // add this number into the current combination
            comb.addLast(num);
            counter.put(num, count - 1);

            // continue the exploration
            backtrack(comb, N, counter, results);

            // revert the choice for the next exploration
            comb.removeLast();
            counter.put(num, count);
        }
    }
}