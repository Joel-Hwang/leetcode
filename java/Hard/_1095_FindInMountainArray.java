package Hard;

import org.testng.annotations.Test;

public class _1095_FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 1; int r = mountainArr.length()-2;
        int top = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int leftVal =mountainArr.get(mid-1);
            int rightVal = mountainArr.get(mid+1); 
            int midVal = mountainArr.get(mid);
            if(leftVal < midVal && midVal > rightVal){
                top = mid;
                break;
            }else if(midVal < rightVal){
                l = mid+1;
            }else if(midVal < leftVal){
                r = mid;
            } else return -1;

        }
        int leftIdx = findLeft(top, target, mountainArr);
        return leftIdx>=0? leftIdx : findRight(top, target, mountainArr);
    }

    private int findLeft(int right, int target, MountainArray mountainArr){
        int l = 0; int r = right;
        while(l<=r){
            int mid = l + (r-l)/2;
            int midVal = mountainArr.get(mid);
            if(midVal == target){
                return mid;
            }else if(midVal < target){
                l = mid+1;
            }else if(midVal > target){
                r = mid-1;
            } else;

        }
        return -1;
    }
    private int findRight(int left, int target, MountainArray mountainArr){
        int l = left; int r = mountainArr.length()-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int midVal = mountainArr.get(mid);
            if(midVal == target){
                return mid;
            }else if(midVal > target){
                l = mid+1;
            }else if(midVal < target){
                r = mid-1;
            } else;

        }
        return -1;
    }

    int findInMountainArray2(int target, MountainArray A) {
        int n = A.length(), l, r, m, peak = 0;
        // find index of peak
        l  = 0;
        r = n - 1;
        while (l < r) {
            m = (l + r) / 2;
            if (A.get(m) < A.get(m + 1))
                l = peak = m + 1;
            else
                r = m;
        }
        // find target in the left of peak
        l = 0;
        r = peak;
        while (l <= r) {
            m = (l + r) / 2;
            if (A.get(m) < target)
                l = m + 1;
            else if (A.get(m) > target)
                r = m - 1;
            else
                return m;
        }
        // find target in the right of peak
        l = peak;
        r = n - 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (A.get(m) > target)
                l = m + 1;
            else if (A.get(m) < target)
                r = m - 1;
            else
                return m;
        }
        return -1;
    }

    class MountainArray {
        int[] ar = null;
        public MountainArray(int[] ar){
            this.ar = ar;
        }
        public int get(int index) {
            return ar[index];
        }
        public int length() {
            return ar.length;
        }
    }




    @Test
    public void test(){
        MountainArray ma = null;
        ma = new MountainArray(new int[]{1,2,3,4,5,3,1});
        findInMountainArray(3, ma);

        ma = new MountainArray(new int[]{0,1,2,4,2,1});
        findInMountainArray(3, ma);
    }
}





