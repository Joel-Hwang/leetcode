package Medium;

import java.util.*;

import org.testng.annotations.Test;

public class _2201_CountArtifactsThatCanBeExtracted {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] uncovered = new boolean[n][n];
        for(int[] d : dig){
            uncovered[d[0]][d[1]] = true;
        }

        int result = 0;
        
        for(int[] artifact: artifacts){
            boolean isUncovered = true;
            label:for(int i = artifact[0]; i<= artifact[2]; i++){
                for(int j = artifact[1]; j<= artifact[3]; j++){
                    if(uncovered[i][j] == false){
                        isUncovered = false;
                        break label;
                    }
                }
            }
            if(isUncovered)
                result++;
        }
                    
        return result;
    }

    public int digArtifacts2(int n, int[][] artifacts, int[][] dig) {
        int result = 0;
        Set<String> digSet = new HashSet<>();
        for(int[] d : dig)
            digSet.add(d[0]+","+d[1]);
        
            for(int[] artifact: artifacts)
                if(canExcavate(artifact, digSet))
                    result++;
        return result;
    }

    private boolean canExcavate(int[] artifact, Set<String> digSet){
        List<String> artifactDetails = new ArrayList<>();
        for(int i = artifact[0]; i<= artifact[2]; i++)
            for(int j = artifact[1]; j<= artifact[3]; j++)
                artifactDetails.add(i+","+j);
        

        for(String artifactDetail: artifactDetails)
            if(digSet.contains(artifactDetail) == false)
                return false;
        return true;
    }

    @Test
    public void test(){
        canExcavate(new int[]{3,1,4,1}, new HashSet<>());
    }
}
