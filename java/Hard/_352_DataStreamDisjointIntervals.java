package Hard;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

import org.testng.annotations.Test;

public class _352_DataStreamDisjointIntervals {
    class SummaryRanges {
        TreeMap<Integer, int[]> tree;

        public SummaryRanges(){
            tree = new TreeMap<>();
        }
        public void addNum(int val){
            if(tree.containsKey(val)) return;
            //else tree.put(val,0);
            Integer l = tree.lowerKey(val);
            Integer h = tree.higherKey(val);

            if(h!= null && val+1 == h){
                if(l != null && val-1 == tree.get(l)[1]){  //가운데 끼인 경우
                    tree.get(l)[1] = tree.get(h)[1];
                }else{ //내가 그룹에서 가장 작은 경우
                    tree.put(val, new int[]{val,tree.get(h)[1]});
                }
                tree.remove(h);
            //새로 들어온 노드가 왼쪽 자식의 범위 안에 들어가거나 왼쪽 범위보다 1 큰 경우
            }else if(l!= null && (tree.get(l)[0] < val && val <= tree.get(l)[1]+1) ){ 
                //새로 들어온 노드와 현재 범위의 end 값을 비교해서 큰 놈
                tree.get(l)[1] = Math.max(tree.get(l)[1],val);
            }else{ //그룹에 속하지 않은 경우
                tree.put(val, new int[]{val,val});
            }
            
        }

        public int[][] getIntervals(){
            int[][] res = new int[tree.size()][2];
            int i = 0;
            Iterator it = tree.keySet().iterator();
            while(it.hasNext()){
                res[i++] = tree.get(it.next());
            }
            for(int j = 0; j<res.length; j++)
                System.out.println(res[j][0] +"\t"+ res[j][1]);
            return res;
        }
    }

    @Test
    public void test() {

        int[] arNum = {49,97,53,5,33,65,62,51,100,38,61,45,74,27,64,17,36,17,96,12,79,32,68,90,77,18,39,12,93,9,87,42,60,71,12,45,55,40,78,81,26,70,61,56,66,33,7,70,1,11,92,51,90,100,85,80,0,78,63,42,31,93,41,90,8,24,72,28,30,18,69,57,11,10,40,65,62,13,38,70,37,90,15,70,42,69,26,77,70,75,36,56,11,76,49,40,73,30,37,23};
       // Arrays.sort(arNum);
        System.out.println(Arrays.toString(arNum));
        SummaryRanges summaryRanges = new SummaryRanges();
        for(int i : arNum)
            summaryRanges.addNum(i);
        
        summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
    }
}
