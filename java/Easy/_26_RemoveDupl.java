package Easy;

public class _26_RemoveDupl {
    public _26_RemoveDupl(){
        removeDuplicates(new int[]{1,1,2});
    }   

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0;
        for(int j = 1; j<nums.length; j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
       
        return i+1; 
    }

}
