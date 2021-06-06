package CS;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Combination {
    public Combination() {
        
    }
    //DFS 탐색이고 마지막 노드 밑에 null일때 print
    public void combination(int[] ar,int start, int pick, String parent){
        if( pick < 1){
            System.out.println(parent);
            return;
        }
        for(int i = start; i<ar.length-(pick-1); i++){
            combination(ar,i+1, pick-1, parent+ar[i]);
        }
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
        //combination(new int[]{2,3,6,7},0,2, "");

        List<List<Integer>> res = new ArrayList<>();
        combination2(new int[]{2,3,6,7}, 0, 3, new ArrayList<Integer>(), res);
        for(List<Integer> row : res){
            for(int i : row){
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
