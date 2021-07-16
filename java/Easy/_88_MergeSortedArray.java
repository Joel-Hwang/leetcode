package Easy;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        if(nums1.length == n){
            for(int i = 0; i<nums1.length; i++)
            nums1[i] = nums2[i];
            return;
        }
        int[] res = new int[m+n];
        int i0 = 0;
        int i1 = 0;
        int i2 = 0;
        while(i1 < m || i2<n){
            if(i2==n || (nums1[i1]<nums2[i2] && i1<m)){
                res[i0++] = nums1[i1++];
            }else{
                res[i0++] = nums2[i2++];
            }
        }
        for(int i = 0; i<nums1.length; i++)
            nums1[i] = res[i];
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? 
                                 nums1[tail1--] : nums2[tail2--];
        }
    
        while (tail2 >= 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }
    }
    @Test
    public void test(){
        int[] n1 = {2,0};
        int[] n2 = {1};
        merge(n1,1,n2,1);
        System.out.println(Arrays.toString(n1));
    }
}
