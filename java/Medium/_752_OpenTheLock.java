package Medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.testng.annotations.Test;

public class _752_OpenTheLock{
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Set<String> deadSet = getDeadSet(deadends);
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int res = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++){
                String cur = q.poll();
                if(deadSet.contains(cur)) continue;
                if(target.equals(cur)) return res;
                addQueue(q, visited, eightNodes(cur));
            }
            res++;
        }
        return -1;
    }
    
    private Set<String> getDeadSet(String[] deadends){
        Set<String> deadSet = new HashSet<>();
        for(String s : deadends) deadSet.add(s);
        return deadSet;
    }

    private void addQueue(Queue<String> queue, Set<String> visited, String[] nodes){
        for(String s : nodes){
            if(visited.contains(s)) continue; 
            queue.add(s); 
            visited.add(s);         
        } 
    }

    private String[] eightNodes(String s){
        String[] res = new String[8];
        String[] a = s.split("");
        int[] arI = new int[4];
        for(int i = 0; i<arI.length; i++) arI[i] = Integer.parseInt(a[i]);
        for(int i = 0; i<arI.length; i++){
            res[i*2] = s.substring(0,i) + ((arI[i]+11)%10) + s.substring(i+1);
            res[i*2+1] = s.substring(0,i) + ((arI[i]+9)%10) + s.substring(i+1);
        } 
        return res;
    }

    @Test
    public void test(){
        assertEquals(-1,openLock(new String[]{"5557","5553","5575","5535","5755","5355","7555","3555","6655","6455","4655","4455","5665","5445","5645","5465","5566","5544","5564","5546","6565","4545","6545","4565","5656","5454","5654","5456","6556","4554","4556","6554"},"5555"));
        assertEquals(-1,openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888"));
        assertEquals(1,openLock(new String[]{"8888"},"0009"));
        assertEquals(6,openLock(new String[]{"0201","0101","0102","1212","2002"},"0202"));
    }
}