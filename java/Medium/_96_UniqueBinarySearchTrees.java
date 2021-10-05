package Medium;

import org.testng.annotations.Test;

public class _96_UniqueBinarySearchTrees {
    /*
    G[n] : 길이가 n일때 유일한 BST 수
    F[i,n] : i가 루트일때 유일한 BTS 수
    G[n] = F[1,n] + F[2,n] + ... + F[n,n]
    G[0] = G[1] = 1  //dp 초기값. 0인건 empty인것도 한개로 침

    F[i,n] = G[i-1]*G[n-i] : i가 root면 왼쪽은 1 ~ i-1의 BST 조합이고
    오른쪽은 i+1 ~ n까지 BST조합이니까 G[i-1]*G[n-1]가 F[i,n]의 값이 됨
    
    정리하면 
    G[n] = G[0]*G[n-1]+G[1]*G[n-2]+...+G[n-1]*G[0]
    
    G[2] = G[0]*G[1] + G[1]*G[0]
    G[3] = G[0]*G[2] + G[1]*G[1] + G[2]*G[0]
    for(int j = 1; j<=n; j++){
        G[j] = G[j-1]*G[n-j];
    }
    */
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = G[1] = 1;
        for(int i = 2; i<=n; i++){
            for(int j = 1; j<=i; j++)
                G[i] += G[j-1]*G[i-j];
        }
        return G[n];
    }

    @Test
    public void test(){
        System.out.println(numTrees(3));
    }
}
