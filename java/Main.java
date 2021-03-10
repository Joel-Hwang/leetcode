import Medium.*;
import CS.LinkedListNode;
import CS.Node;
import Easy.*;
import Hard.*;

public class Main {
    public static void main(String[] args) {
       new _480_SlidingWindowMedian();
       //test();
    }
    //[-3,-2,1,5] , 2(n), -3(o) -> [-2,1,2,5]
    public static int[] test(){
        int[] num = {2,2,2,3,4,5};
        int o = 2;
        int n = 1;
        if(n == o) return num;

        if(n>o){
            for(int i = 0; i<num.length; i++){
                if(num[i]>n){
                    num[i-1] = n;
                    break;
                }
                if(i == num.length-1){
                    num[i] = n;
                    break;
                }
                if(num[i] >= o && num[i] <= n){
                    num[i] = num[i+1];
                }
            }
        }else{
            for(int i = num.length-1; i>=0; i--){
                if(num[i]<n){
                    num[i+1] = n;
                    break;
                } 
                if(i == 0){
                    num[i] = n;
                    break;
                }
                if(num[i] <= o && num[i] >= n){
                    num[i] = num[i-1];
                }
            }
        }
        return num;
        
    }
}