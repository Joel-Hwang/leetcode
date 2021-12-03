package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.testng.annotations.Test;

public class _239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        ArrayList<Integer> cur = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            cur.add(nums[i]);
        }
        Collections.sort(cur);
        res[0] = cur.get(cur.size() - 1);
        delNumInList(cur,nums[0]);

        for (int i = k; i < nums.length; i++) {
            // put nums[k] in cur
            addNumInList(cur,nums[i]);
            res[i - k + 1] = cur.get(cur.size() - 1);
            delNumInList(cur,nums[i - k + 1]);
        }

        return res;
    }

    private void addNumInList(ArrayList<Integer> arr, int num){
        int l=0,r=arr.size()-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr.get(mid) < num){
                l = mid + 1;
            }else{
                r = mid-1;
            }
        }
        arr.add(l, num);
    }

    private void delNumInList(ArrayList<Integer> arr, int num){
        int l=0,r=arr.size()-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr.get(mid) == num){
                arr.remove(mid);
                return;
            }else if(arr.get(mid) < num){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
    }

    @Test
    public void test(){
        System.out.println(
            Arrays.toString(
                maxSlidingWindow(
                    new int[]{1}, 1
                )
            )
        );

        System.out.println(
            Arrays.toString(
                maxSlidingWindow(
                    new int[]{1,-1}, 1
                )
            )
        );

        System.out.println(
            Arrays.toString(
                maxSlidingWindow(
                    new int[]{4,-2}, 2
                )
            )
        );

        System.out.println(
            Arrays.toString(
                maxSlidingWindow(
                    new int[]{9,11}, 2
                )
            )
        );

        System.out.println(
            Arrays.toString(
                maxSlidingWindow(
                    new int[]{1,3,-1,-3,5,3,6,7}, 3
                )
            )
        );
    }
}
