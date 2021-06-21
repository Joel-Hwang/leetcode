package Hard;

import org.testng.annotations.Test;

public class _60_PermutationSequence {
    public String getPermutation(int n, int k) { 
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=n; i++) sb.append(i);
        Ref rk = new Ref(k);
        permutation(sb, 0, n, "",rk);

        return rk.res;
    }

    //DFS 탐색이고 마지막 노드 밑에 null일때 print
    public void permutation(StringBuilder sb,int start, int pick, String parent, Ref rK){
        if(rK.k <= 0) return;

        if( pick < 1){
            rK.k--;
            if(rK.k==0)
                rK.res = parent;
            return;
        }

        for(int i = start; i<sb.length(); i++){
            String pTemp = parent;
            parent = parent+sb.charAt(i);
            //System.out.println("parent : " + parent);
            char temp = sb.charAt(i); 
            sb.delete(i, i+1);
            sb.insert(parent.length()-1,temp);
            //System.out.println("swap : " + sb);
            
            permutation(sb,start+1,pick-1,parent,rK);
            sb.delete(parent.length()-1,parent.length());
            sb.insert(i,temp);
            //System.out.println("reverse swap : " + sb);
            parent = pTemp;
        }
    }

    class Ref{
        int k = 0; 
        String res = "";
        public Ref(int k){
            this.k = k;
        }
    }


    @Test
    public void test(){
        getPermutation(3,5);
    }
}
