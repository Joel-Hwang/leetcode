package Easy;

import org.testng.annotations.Test;

public class _414_ThirdMaximumNumber {
  public int thirdMax(int[] nums) {
    Integer[] ar = new Integer[3];

    for (int n : nums) {
      if (ar[0] != null && n == ar[0])
        continue;
      if (ar[0] == null || n > ar[0]) {
        ar[2] = ar[1];
        ar[1] = ar[0];
        ar[0] = n;
        continue;
      }
      if (ar[1] != null && n == ar[1])
        continue;
      if (ar[1] == null || n > ar[1]) {
        ar[2] = ar[1];
        ar[1] = n;
        continue;
      }
      if (ar[2] != null && n == ar[2])
        continue;
      if (ar[2] == null || n > ar[2]) {
        ar[2] = n;
      }

    }

    return ar[2] == null ? ar[0] : ar[2];
  }

  @Test
  public void test() {
    System.out.println(thirdMax(new int[] { 3, 2, 1 }));
    System.out.println(thirdMax(new int[] { 1, 2 }));
    System.out.println(thirdMax(new int[] { 2, 2, 3, 1 }));
    System.out.println(thirdMax(new int[] { 1, 2, -2147483648 }));
  }
}
