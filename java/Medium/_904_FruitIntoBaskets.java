package Medium;

import org.testng.annotations.Test;

public class _904_FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int res = 0, cur = 0, b1 = fruits[0], b2 = -1, cntB2 = 0;
        for (int f : fruits) {
            cur = f == b1 || f == b2 ? cur + 1 : cntB2 + 1;
            cntB2 = f == b2 ? cntB2 + 1 : 1;
            if(f != b2){
                b1 = b2;
                b2 = f;
            }
            res = Math.max(res, cur);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(totalFruit(new int[] { 1, 0, 1, 4, 1, 4, 1, 2, 3 }));

        System.out.println(totalFruit(new int[] { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 }));
        System.out.println(totalFruit(new int[] { 1, 2, 3, 2, 2 }));
        System.out.println(totalFruit(new int[] { 0, 1, 1, 2 }));
        System.out.println(totalFruit(new int[] { 1, 2, 1 }));
    }
}
