package Hard;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class _295_FindMedialFromDataStream {
    class MedianFinder {
        List<Integer> list;

        /** initialize your data structure here. */
        public MedianFinder() {
            list = new ArrayList();
        }

        public void addNum(int num) {
            if(list.size() == 0){
                list.add(num);
                return;
            }
            if (list.get(0) >= num) {
                list.add(0, num);
                return;
            }
            if (list.get(list.size()-1) <= num) {
                list.add(num);
                return;
            }

            int l = 0, r = list.size() - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (num > list.get(m)) {
                    l = m+1;
                } else {
                    r = m;
                }
            }
            list.add(l, num);
        }

        public double findMedian() {
            if (list.size() % 2 == 1)
                return list.get(list.size() / 2);
            else
                return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;
        }
    }

    @Test
    public void test() {
        /*
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1); // arr = [1]
        medianFinder.addNum(2); // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3); // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
*/

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6); // arr = [1]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(10); // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 2.0
        medianFinder.addNum(2); // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
        medianFinder.addNum(6); // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
        medianFinder.addNum(5); // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
        medianFinder.addNum(0); // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
        medianFinder.addNum(6); // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
        medianFinder.addNum(3); // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
        medianFinder.addNum(1); // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
        medianFinder.addNum(0); // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
        medianFinder.addNum(0); // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }
}
