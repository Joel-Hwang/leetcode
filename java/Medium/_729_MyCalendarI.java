package Medium;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class _729_MyCalendarI{
    class MyCalendar {
        ArrayList<int[]> cal;
        public MyCalendar() {
            cal = new ArrayList<>();
        }
        
        public boolean book(int start, int end) {
            int l = 0, r = cal.size()-1;
            while(l<=r){
                int m = (l+r)/2;
                if(cal.get(m)[1] <= start){
                    l = m+1;
                }else if(end <= cal.get(m)[0]){
                    r = m-1;
                }else{
                    return false;
                }
            }
            cal.add(l, new int[]{start,end});
            return true;
        }
    }

    @Test
    public void test(){
        MyCalendar obj = new MyCalendar();
        System.out.println(obj.book(10, 20));
        System.out.println(obj.book(15, 25));
        System.out.println(obj.book(20, 30));
        System.out.println(obj.book(40, 50));
        System.out.println(obj.book(20, 25));
        System.out.println(obj.book(30, 40));
    }
} 