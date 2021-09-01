package Medium;


import org.testng.annotations.Test;

public class _565_ArrayNesting {
    public int arrayNesting2(int[] nums) {
        int res = 0;
        
        boolean[] visited = new boolean[nums.length];
        for(int i = 0; i<nums.length; i++){
            if(visited[i]) continue;
            res = Math.max(res,getNestLength(nums,i,visited));
        }
        return res;
    }

    private int getNestLength(int[] nums,int i,boolean[] visited){
        int curIdx = i;
        int res = 1;
        visited[curIdx] = true;
        while(i != nums[curIdx]){
            curIdx = nums[curIdx];
            visited[curIdx] = true;
            res++;
        }
        return res;
    }

    public int arrayNesting(int[] A){
        int res = 0, n = A.length;
        boolean[] seen = new boolean[n];
        for(int v: A){
            int cnt = 0;
            while(!seen[v]){
                seen[v] = true;
                cnt++;
                v = A[v];
            }
            res = Math.max(res,cnt);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(arrayNesting(new int[]{0,1,2}));
        System.out.println(arrayNesting(new int[]{5,4,0,3,1,6,2}));
    }
}
