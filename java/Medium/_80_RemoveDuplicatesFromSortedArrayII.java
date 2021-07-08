package Medium;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _80_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int res = nums.length;
        int cur = nums[0], curCnt = 1, move = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) {
                curCnt++;
                if (curCnt > 2) {
                    res--;
                    nums[i]--;
                }
            } else {
                cur = nums[i];
                curCnt = 1;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                move++;
                nums[i] = nums[i - 1];
            } else {
                nums[i - move] = nums[i];
            }
        }

        return res;
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }

    @Test
    public void test() {
        System.out.println(removeDuplicates2(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 4, 4 }));
    }
}
