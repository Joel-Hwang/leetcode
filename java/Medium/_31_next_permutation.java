package Medium;

import java.util.Arrays;

public class _31_next_permutation{
    public _31_next_permutation(){
        int[] a = {5,4,7,5,3,2};
        nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }

    //[4,5,3,2,1]
    public void nextPermutation(int[] nums) {
        int i = nums.length -2;
        //find 4. idx = 0
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        
        //find near biggest one and swap
        if(i>=0){
            int j = nums.length-1;
            while(nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        //reverse 4,3,2,1
        reverse(nums,i+1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start){
        for(int i = start; i< start +(nums.length-start)/2; i++){
            swap(nums,i,nums.length-i-1+start);
        }
    }
}

/*

마지막에 45321 이런식으로 높았다 낮아지는곳 캐치.
5321 중에 4랑 가깝게 큰 놈이랑 바꾸면 54321 이렇게 됨.
그리고 4321을 Reverse하면 1234. Reverse는 배열 반으로 접어서 swap 반복
앞이 1,8,2,7, 이렇게 요동처도 뒤에만 신경쓰면 됨 3,6,5,4 

*/