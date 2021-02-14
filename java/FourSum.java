public class FourSum {
    public ForSum(){}
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i<nums.length-3; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            List<List<Integer>> thsum = ThreeSum(Arrays.copyOfRange(nums, i+1,nums.length),target-nums[i]);
            for(int j = 0; j<thsum.size(); j++){
                thsum.get(j).add(nums[i]);
                result.add(thsum.get(j));
            }
        }

        return result;
    }

    public List<List<Integer>> ThreeSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i<nums.length-2; i++){
            int l=i+1, r=nums.length-1;
            if(i>0 && nums[i] == nums[i-1]) continue;
            while(l<r){
                int sum = nums[i];
                if(nums[l] + nums[r] + sum == target){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    temp.add(sum);
                    result.add(temp);

                    while(l<r&&nums[l] == nums[l+1]) l++;
                    while(l<r&&nums[r] == nums[r-1]) r--;
                    l++;r--;
                }else if( nums[l] + nums[r] + sum < target ){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return result;
    }
}