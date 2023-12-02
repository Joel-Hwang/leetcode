package Medium;

import java.util.TreeSet;

public class _1818_MinimumAbsoluteSumDifference {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int maxDecrease = 0;
        int len = nums1.length;
        long sum = 0;
        int mod = 1000000007;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int num : nums1) treeSet.add(num);
        for(int i = 0; i<len; i++){
            int diff = Math.abs(nums1[i]-nums2[i]);
            sum += diff;
            if(nums1[i] != nums2[i]){
                Integer ceil = treeSet.ceiling(nums2[i]);
                Integer floor = treeSet.floor(nums2[i]);
                if(ceil != null){
                    int val1 = Math.abs(ceil-nums2[i]);
                    maxDecrease = Math.max(maxDecrease, diff-val1);
                }
                if(floor != null){
                    int val2 = Math.abs(floor-nums2[i]);
                    maxDecrease = Math.max(maxDecrease, diff-val2);
                }

            }
        }
        return (int)((sum-maxDecrease)%mod);
    }
}
