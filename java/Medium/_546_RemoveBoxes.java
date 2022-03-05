package Medium;

public class _546_RemoveBoxes {

    int[][][] memo;
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        memo = new int[n][n][n];
        return dp(boxes,0,n-1,0);
    }

    private int dp(int[] boxes, int l, int r, int k){
        if(r<l) return 0;
        if(memo[l][r][k]>0) return memo[l][r][k];
        int oriL = l, oriK = k;
        while(l+1<=r && boxes[l+1] == boxes[l]){
            l++; k++;
        }
        int ans = (k+1)*(k+1)+dp(boxes,l+1,r,0);
        for(int j = l+1; j<=r; j++){
            if(boxes[l] == boxes[j]){
                int temp = dp(boxes,j,r,k+1) + dp(boxes,l+1,j-1,0);
                ans = Math.max(ans,temp);
            }
        }
        return memo[oriL][r][oriK] = ans;
    }

   

   
}
