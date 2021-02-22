import java.util.LinkedList;

public class MinMovesConsecutive {
    public MinMovesConsecutive(){
        int[] a = {1,0,0,0,0,0,1,1};
        System.out.println(minMoves(a, 3));
    }

    public int minMoves(int[] nums, int k) {
        LinkedList<Integer> ones = new LinkedList<>();
        LinkedList<Integer> presum = new LinkedList<>();
        presum.add(0);
        if(k == 1) return 0;
        for(int i = 0; i<nums.length; i++)
            if(nums[i] == 1){
                ones.add(i);
                presum.add(presum.getLast() + i);
            }
        int rad = (k-1)/2;
        int ans = Integer.MAX_VALUE;
        for(int mid = (k-1)/2 ;mid < ones.size() - (k/2); mid++ ){
            int left = presum.get(mid);
            int right = presum.get(mid + rad + 1) - presum.get(mid+1);
            int save =  right - left - rad*(rad+1);
            ans = Math.min(save, ans);
        }

        
        return ans;
    }
    
}
