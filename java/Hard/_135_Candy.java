package Hard;

import org.testng.annotations.Test;

public class _135_Candy {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        left[0] = 1;
        right[right.length - 1] = 1;
        for (int i = 1; i < left.length; i++) {
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }

        for (int i = right.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        }

        int res = 0;
        for(int i = 0; i<left.length; i++){
            res += Math.max(left[i], right[i]);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(candy(new int[] { 1, 2, 3, 1, 0 }));
        System.out.println(candy(new int[] { 1, 3, 4, 5, 2 })); // 11
        System.out.println(candy(new int[] { 1, 3, 2, 2, 1 })); // 7
        System.out.println(candy(new int[] { 1, 2, 2 })); // 4
        System.out.println(candy(new int[] { 1, 0, 2 })); // 5
    }
}
