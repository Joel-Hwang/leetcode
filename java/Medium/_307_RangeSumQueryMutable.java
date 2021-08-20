package Medium;

import org.testng.annotations.Test;

public class _307_RangeSumQueryMutable {
    class NumArray {
        SegmentTree root;
        int[] nums;
        public NumArray(int[] nums) {
            this.nums = nums;
            root = getSegmentTree(0,nums.length-1, nums);
        }

        public void update(int index, int val) {
            recUpdate(index,val-nums[index],root);
            nums[index] = val;
        }
        

        public int sumRange(int left, int right) {
            return getSum(left, right, root);
        }

        public SegmentTree getSegmentTree(int start, int end, int[] nums){
            if(start == end){
                return new SegmentTree(start, end, nums[start]);
            }
            int mid = (start+end)/2;
            SegmentTree node = new SegmentTree(start, end, 0);
            node.left = getSegmentTree(start, mid,nums);
            node.right = getSegmentTree(mid+1,end,nums);
            node.value = node.left.value + node.right.value;
            return node;
        }
        public void recUpdate(int index, int val, SegmentTree node){
            if(node == null) return;
            if(node.start <= index && index <= node.end){
                node.value += val;
                recUpdate(index, val, node.left);
                recUpdate(index, val, node.right);
            }
        }
        public int getSum(int start, int end, SegmentTree node){
            if(start > node.end || end < node.start) return 0;
            if( start <= node.start && node.end <= end) return node.value;
            
            return getSum(start,end,node.left) + getSum(start,end,node.right);
        }
    }

    class SegmentTree {
        int start;
        int end;
        int value;
        SegmentTree left;
        SegmentTree right;

        public SegmentTree(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        
    }

    @Test
    public void test(){
        NumArray na = new NumArray(new int[]{7,2,7,2,0});
        na.update(4, 6);
        na.update(0, 2);
        na.update(0, 9);
        System.out.println(na.sumRange(4, 4));
        na.update(3, 8);
        System.out.println(na.sumRange(0, 4));
    }

}
