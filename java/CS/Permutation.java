package CS;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Permutation {
    public Permutation() {
        
    }
    //DFS 탐색이고 마지막 노드 밑에 null일때 print
    public void permutation(int[] ar,int start, int pick, String parent){
        if( pick < 1){
            System.out.println(parent);
            return;
        }

        for(int i = start; i<ar.length; i++){
            String temp = parent;
            parent = parent+ar[i];
            swap(ar,parent.length()-1,i);
            permutation(ar,start+1,pick-1,parent);
            swap(ar,i,parent.length()-1);
            parent = temp;
        }
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
    
    @Test
    public void test(){
        permutation(new int[]{1,2,3,4},0,4, "");
        /*List<List<Integer>> res = new ArrayList<>();
        permutation2(new int[]{2,3,6,7},0,2, new ArrayList<Integer>(),res);
        for(List<Integer> row : res){
            for(int i : row){
                System.out.print(i + ", ");
            }
            System.out.println();
        }*/
    }
}
