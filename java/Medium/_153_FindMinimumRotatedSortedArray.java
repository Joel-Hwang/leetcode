package Medium;

import org.testng.annotations.Test;

public class _153_FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1,m;
        while (l < r) {
            m = (l + r) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }

    @Test
    public void test(){
        //l<=r, l = m+1, r = m-1 이렇게 하면 3,1,2일 경우 3이 리턴
        //중간값이 답인 1인데 r = m-1이 되버리니까 중간값 넘어가버림.
        //이렇게 하려면 전형적인 binary search인 target == nums[m] 체크하는 if가 추가되어야 함
        //여기선 그냥 최소값 찾는 거기 때문에 쓸 수 없음
        System.out.println(findMin(new int[]{3,1,2}));
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
    }
}
