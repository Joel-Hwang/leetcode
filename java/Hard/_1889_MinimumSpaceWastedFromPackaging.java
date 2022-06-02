package Hard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.testng.annotations.Test;

public class _1889_MinimumSpaceWastedFromPackaging {

    public int minWastedSpace(int[] pkg, int[][] boxes) {
        long inf = (long) 1e11, res = inf, mod = (long) 1e9 + 7, sumA = 0L;
        Arrays.sort(pkg);
        for (int pck : pkg)
            sumA += pck;

        for (int[] box : boxes) {
            Arrays.sort(box);
            if (box[box.length - 1] < pkg[pkg.length - 1]) continue;

            long curSpace = getWastedSpace(pkg, box);
            res = Math.min(res, curSpace);
        }
        return res < inf ? (int) ((res - sumA) % mod) : -1;
    }

    private long getWastedSpace(int[] pkgs, int[] box) {
        long cur = 0;
        long i = 0;
        for (int b : box) {
            int l = 0, r = pkgs.length;
            while (l < r) {
                int m = (l + r) / 2;
                if (pkgs[m] < b + 1)
                    l = m + 1;
                else
                    r = m;
            }

            cur += b * (l - i);
            i = l;
        }
        return cur;
    }

    public int minWastedSpace3(int[] pkg, int[][] boxes) {
        Arrays.sort(pkg);
        long inf = (long) 1e11, res = inf, mod = (long) 1e9 + 7, sumA = 0L;
        for (int a : pkg)
            sumA += a;

        for (int[] box : boxes) {
            Arrays.sort(box);
            if (box[box.length - 1] < pkg[pkg.length - 1]) continue;
            long cur = 0, i = 0;
            for (int b : box) {
                int l = 0, r = pkg.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if (pkg[m] < b+1)
                        l = m + 1;
                    else
                        r = m;
                }
                cur += b * (l - i);
                i = l;
            }
            res = Math.min(res, cur);
        }
        return res < inf ? (int) ((res - sumA) % mod) : -1;
    }

    public int minWastedSpace2(int[] pkg, int[][] boxes) {
        Arrays.sort(pkg);
        long inf = (long) 1e11, res = inf, mod = (long) 1e9 + 7, sumA = 0L;
        for (int a : pkg)
            sumA += a;
        for (int[] box : boxes) {
            Arrays.sort(box);
            if (box[box.length - 1] < pkg[pkg.length - 1]) continue;
            long cur = 0, i = 0; int j;
            for (int b : box) {
                j = binarySearch(pkg, b + 1);
                cur += b * (j - i);
                i = j;
            }
            res = Math.min(res, cur);
        }
        return res < inf ? (int) ((res - sumA) % mod) : -1;
    }

    private int binarySearch(int[] pkg, int b) {
        int l = 0, r = pkg.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (pkg[m] < b)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

    @Test
    public void test() {
        int[] pkg = new int[100000];
        for(int i = 0; i<pkg.length; i++) pkg[i] = (i+1);
        int[][] boxes = new int[50000][2];
        for(int i = 0; i<boxes.length; i++){
            boxes[i][0] = 50000 + i;
            boxes[i][1] = 100000;

        }

        assertEquals(499949986, minWastedSpace(pkg, boxes ));
        //assertEquals(-1, minWastedSpace3(new int[] { 2, 3, 5 }, new int[][] { { 1, 4 }, { 2, 3 }, { 3, 4 } }));
        //assertEquals(6, minWastedSpace(new int[] { 2, 3, 5 }, new int[][] { { 4, 8 }, { 2, 8 } }));
    }
}
