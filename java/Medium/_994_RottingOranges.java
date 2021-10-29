package Medium;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class _994_RottingOranges {
    public int orangesRotting(int[][] grid) {
        int init = isExistFresh(grid);
        if(init<2) return init;
        int res = 0;
        ArrayList<int[]> rotten = new ArrayList<>();
        
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    rotten.add(new int[]{i,j});
                }
            }
        }


        ArrayList<int[]> newRotten = setRotten(grid, rotten);
        while(newRotten.size() >0 ){
            res++;
            newRotten = setRotten(grid, newRotten);
        }
        return isExistFresh(grid)==2?-1:res;
    }

    public int isExistFresh(int[][] grid){
        boolean isRotten = false;
        boolean isFresh = false;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                boolean t=false,l=false,b=false,r=false;
                if(grid[i][j]==1){
                    isFresh = true;
                    if(i==0 || grid[i-1][j]==0) t = true;
                    if(i==grid.length-1|| grid[i+1][j]==0) b = true;
                    if(j==0 || grid[i][j-1]==0) l = true;
                    if(j==grid[0].length-1 || grid[i][j+1]==0) r = true;
                    if(t&&l&&b&&r) return -1;
                }
                if(grid[i][j] == 2) isRotten = true;
            }
        }
        if(!isFresh) return 0;
        if(!isRotten) return -1;
        return 2;
    }

    public ArrayList<int[]> setRotten(int[][] grid, ArrayList<int[]> rotten){
        ArrayList<int[]> newRottens = new ArrayList<>();
        for(int i = 0; i<rotten.size(); i++){
            int row = rotten.get(i)[0];
            int col = rotten.get(i)[1];
            ArrayList<int[]> newRotten = set4Dir(grid,row,col);
            newRottens.addAll(newRotten);
        }
        return newRottens;
    }

    private ArrayList<int[]> set4Dir(int[][] grid, int row, int col){
        ArrayList<int[]> res = new ArrayList<>();
        if(row+1 < grid.length && grid[row+1][col]==1){
            grid[row+1][col] = 2;
            res.add(new int[]{row+1,col});
        }
        if(col+1 < grid[0].length && grid[row][col+1]==1){
            grid[row][col+1] = 2;
            res.add(new int[]{row,col+1});
        }  
        if(row-1 >= 0  && grid[row-1][col]==1){
            grid[row-1][col] = 2;
            res.add(new int[]{row-1,col});
        }
        if( col-1 >=0 && grid[row][col-1]==1){
            grid[row][col-1] = 2;
            res.add(new int[]{row,col-1});
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(orangesRotting(new int[][]{{2},{2},{1},{0},{1},{1}}));
        System.out.println(orangesRotting(new int[][]{{0}}));
        System.out.println(orangesRotting(new int[][]{{1},{1},{1},{1}}));
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }

}
