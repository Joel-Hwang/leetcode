package CS;

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

    @Test
    public void test(){
        combination(new int[]{2,3,6,7},0,2, "");
    }
}