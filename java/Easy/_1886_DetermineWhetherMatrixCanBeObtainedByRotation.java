package Easy;

public class _1886_DetermineWhetherMatrixCanBeObtainedByRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i = 0; i<4; i++){
            if(equals(mat,target)) 
                return true;
            mat = turn90(mat);
        }
        return false;
    }

    private int[][] turn90(int[][] mat){
        int[][] result = new int[mat.length][mat[0].length];
        for(int j = mat[0].length-1, matI = 0; j>=0; j--, matI++)
            for(int i = 0,  matJ = 0; i<mat.length; i++,matJ++)
                result[i][j]=mat[matI][matJ];
        return result;
    }

    private boolean equals(int[][] source, int[][] target){
        for(int i = 0; i<source.length; i++)
            for(int j = 0; j<source[i].length; j++)
                if(source[i][j] != target[i][j])
                    return false;
        return true;
    }
}
