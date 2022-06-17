package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _2040_KthSmallestProductOfTwoSortedArrays {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000001l, high = 10000000001l;
        while( low < high ){
            long cnt = 0;
            //long mid = (low + high) / 2;
            long mid = low + ((high - low) / 2);
            //long mid = low + ((high - low) >> 1), cnt = 0;
            for(int num : nums1){
                if(num > 0){
                    cnt += getCountForPositive(num, nums2, mid);
                }else{
                    cnt += getCountForNegative(num, nums2, mid);
                }
            }

            if (cnt >= k) {
                high = mid;
            } else low = mid + 1;
        }

        return low;   
    }

    private int getCountForPositive(int num, int[] nums, long target){
        int l = 0, r = nums.length-1;
        while(l <= r){
            int m = l + ((r - l) / 2);
            if( (long)num * nums[m] <= target) l = m+1;
            else r = m-1;
        }
        return l;
    }

    private int getCountForNegative(int num, int[] nums, long target){
        int l = 0, r = nums.length-1;
        while(l <= r){
            int m = l + ((r - l) / 2);
            if( (long)num * nums[m] <= target) r = m-1;
            else l = m+1;
        }
        return nums.length-l;
    }

    public long kthSmallestProduct2(int[] nums1, int[] nums2, long k) {
        int n = nums2.length;
        long lo = -10000000001l, hi =  10000000001l;
        while (lo < hi) {            
            long mid = lo + ((hi - lo) >> 1), cnt = 0;
            for (int i : nums1) {
                if (0 <= i) {
                    int l = 0, r = n - 1, p = 0;
                    while (l <= r) {
                        int c = l + ((r - l) >> 1);
                        long mul = i * (long) nums2[c];
                        if (mul <= mid) {
                            p = c + 1;
                            l = c + 1;
                        } else r = c - 1;
                    }
                    cnt += p;
                } else {
                    int l = 0, r = n - 1, p = 0;
                    while (l <= r) {
                        int c = l + ((r - l) >> 1);
                        long mul = i * (long) nums2[c];
                        if (mul <= mid) {
                            p = n - c;
                            r = c - 1;
                        } else l = c + 1;
                    }
                    cnt += p;
                }
            }
            if (cnt >= k) {
                hi = mid;
            } else lo = mid + 1L;
        }
        return lo;
    }

    @Test
    public void test(){
        assertEquals(-10000000000l, kthSmallestProduct(new int[]{-100000,100000}, new int[]{-100000,100000}, 1));
        assertEquals(8, kthSmallestProduct(new int[]{2,5}, new int[]{3,4}, 2));
        assertEquals(0, kthSmallestProduct(new int[]{-4,-2,0,3}, new int[]{2,4}, 6));
        assertEquals(-6, kthSmallestProduct(new int[]{-2,-1,0,1,2}, new int[]{-3,-1,2,4,5}, 3));
    }
}
