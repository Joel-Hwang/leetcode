package Medium;

import java.util.*;

import org.testng.annotations.Test;

public class _433_MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        Queue<Data> q = new LinkedList<Data>();
        Data root = new Data(start,null);
        q.add(root);
        int depth = 0;
        while(!q.isEmpty()){
            depth++;
            int n = q.size();
            for(int i = 0; i<n; i++){
                Data node = q.poll();
                List<Data> children = children(node, bank);
                for(Data child : children){
                    if(end.equals(child.gene)) return depth;
                    q.add(child);
                }
            }
        }
        
        return -1;
    }

    private List<Data> children(Data p,String[] bank){
        List<Data> res = new ArrayList<Data>();
        String gene = p.gene;
    
        for(String b : bank){
            if(p.set.contains(b)) continue;
            if(isOne(gene, b)) res.add(new Data(b,p.set));
        }
        return res;
    }

    class Data{
        String gene;
        Set<String> set = new HashSet<String>();
        public Data(String gene, Set<String> parent){
            this.gene = gene;
            if(parent != null) set.addAll(parent);
            set.add(gene);
        }
    }

    private boolean isOne(String start, String end){
        int diffCnt = 0;
        for(int i = 0; i<start.length(); i++){
            if(start.charAt(i) != end.charAt(i)) diffCnt++;
            if(diffCnt>1) return false;
        }
        return diffCnt == 1;
    }

  

    @Test
    public void test(){
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"}));
        System.out.println(minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
        System.out.println(minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"}));
    }
}

