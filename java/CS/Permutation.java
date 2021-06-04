package CS;

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
            swap(ar,0,i);
            permutation(ar,start+1,pick-1,parent+ar[0]);
            swap(ar,i,0);
        }
    }

    public void swap(int[] ar, int a, int b){
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }

    @Test
    public void test(){
        permutation(new int[]{2,3,6,7},0,3, "");
    }
}
