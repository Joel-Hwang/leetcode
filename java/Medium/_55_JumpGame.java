package Medium;

public class _55_JumpGame {
    
    public _55_JumpGame(){
        canJump(new int[]{3,2,1,0,4});
    }

    public boolean canJump(int[] nums) {
        if(nums.length ==1) return true;
        int idxLast = nums.length-1;

        for(int i = idxLast-1; i>=0; i--){
            if(nums[i] >= (idxLast - i)){
                idxLast = i;
            }
        }
        return idxLast==0;
    }
}
