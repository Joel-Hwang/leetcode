package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.Test;

public class _287_FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        slow = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    @Test
    public void test(){
        assertEquals(3, findDuplicate(new int[]{1,3,3,4,2}) );
        assertEquals(2, findDuplicate(new int[]{1,3,4,2,2}) );
        assertEquals(1, findDuplicate(new int[]{1,2,3,1}) );
    }
}
