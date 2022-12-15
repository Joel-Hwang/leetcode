package Medium;

import org.testng.annotations.Test;

public class _2245_MaximumTrailingZerosInaCorneredPath {
    public int maxTrailingZeros(int[][] grid){
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] twoGridCol = new int[m][n];
        int[][] twoGridRow = new int[m][n];
        int[][] fiveGridCol = new int[m][n];
        int[][] fiveGridRow = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int two = getElem(grid[i][j], 2);
                int five = getElem(grid[i][j], 5);
                setPreSum(twoGridCol,i,j,true,two);
                setPreSum(twoGridRow,i,j,false,two);

                setPreSum(fiveGridCol,i,j,true,five);
                setPreSum(fiveGridRow,i,j,false,five);
            }
        }

        for(int i = 0; i<m;i++){
            for(int j = 0; j < n; j++){
                //1. col
                res = Math.max(res, getStraight(grid, twoGridCol, fiveGridCol, i, j));
                //2. row
                res = Math.max(res, getStraight(grid, twoGridRow, fiveGridRow, i, j));
                //3. TopToRight
                res = Math.max(res, getTopToRight(grid, twoGridCol, twoGridRow, fiveGridCol,fiveGridRow, i, j));
                //4. TopToLeft
                res = Math.max(res, getTopToLeft(grid, twoGridCol, twoGridRow, fiveGridCol,fiveGridRow, i, j));
                //5. BottomToLeft
                res = Math.max(res, getBottomToLeft(grid, twoGridCol, twoGridRow, fiveGridCol,fiveGridRow, i, j));
                //6. BottomToRight
                res = Math.max(res, getBottomToRight(grid, twoGridCol, twoGridRow, fiveGridCol,fiveGridRow, i, j));
            }
        }

        return res;
    }

    private int getStraight(int[][] grid, int[][] twoPresum, int[][] fivePresum, int i, int j){
        return Math.min(twoPresum[i][j], fivePresum[i][j]);
    }

    private int getTopToRight(int[][] grid, int[][] twoCols, int[][] twoRows, int[][] fiveCols, int[][] fiveRows, int i, int j){
        int n = grid[0].length-1;

        int twoTop = twoRows[i][j];
        int fiveTop = fiveRows[i][j];

        int twoRight = twoCols[i][n] - twoCols[i][j];
        int fiveRight = fiveCols[i][n] - fiveCols[i][j];

        return Math.min(twoTop+twoRight,fiveTop+fiveRight);
    }

    private int getTopToLeft(int[][] grid, int[][] twoCols, int[][] twoRows, int[][] fiveCols, int[][] fiveRows, int i, int j){

        int twoTop = twoRows[i][j];
        int fiveTop = fiveRows[i][j];

        int twoLeft = j>0?twoCols[i][j-1]:0;
        int fiveLeft = j>0?fiveCols[i][j-1]:0;

        return Math.min(twoTop+twoLeft,fiveTop+fiveLeft);
    }

    private int getBottomToLeft(int[][] grid, int[][] twoCols, int[][] twoRows, int[][] fiveCols, int[][] fiveRows, int i, int j){
        int m = grid.length-1;

        int twoBottom = twoRows[m][j] - twoRows[i][j];
        int fiveBottom = fiveRows[m][j] - fiveRows[i][j];

        int twoLeft = twoCols[i][j];
        int fiveLeft = fiveCols[i][j];

        return Math.min(twoBottom+twoLeft,fiveBottom+fiveLeft);
    }

    private int getBottomToRight(int[][] grid, int[][] twoCols, int[][] twoRows, int[][] fiveCols, int[][] fiveRows, int i, int j){
        int m = grid.length-1;
        int n = grid[0].length-1;

        int twoBottom = twoRows[m][j] - twoRows[i][j];
        int fiveBottom = fiveRows[m][j] - fiveRows[i][j];

        int twoRight = j>0?twoCols[i][n] - twoCols[i][j-1]:twoCols[i][n];
        int fiveRight = j>0?fiveCols[i][n] - fiveCols[i][j-1]:fiveCols[i][n];

        return Math.min(twoBottom+twoRight,fiveBottom+fiveRight);
    }


    public void setPreSum(int[][] grid, int i, int j, boolean isCol, int value){
        if(isCol)
            grid[i][j] = j > 0 ? grid[i][j-1] + value : value;
        else
            grid[i][j] = i > 0 ? grid[i-1][j] + value : value;
    }

    public int getElem(int a, int div){
        int res = 0;
        while(a>0 && a%div == 0){
            res++;
            a/=div;
        }
        return res;
    }

    public boolean isInArray(int[][] grid, int i, int j){
        return 0<=i && i< grid.length && 0<=j && j<grid[0].length;
    }

    public int maxTrailingZeros2(int[][] grid) {
        //trailing 0, 10->1, 100->2
        //10 = 2 * 5
        //100 = 2*2*5*5
        //etc.
        //min(countOf2,countOf5);
		//Part 1: move only horizontal
		//Part 2: move only vertically
        //Part 3: one L turn
        //Part 4: one 7 turn
        //Part 5: one J turn
        //Part 6: one |` turn
        
		//Create PrefixSum array to store count of 2 and 5, then we need O(1) time to get count of 2 or 5.
        //matrix count of 2, in row i, from j to k (j<=k) matrix2[i+1][k+1] - matrix2[i+1][j]
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix2row = new int[m+1][n+1];
        int[][] matrix5row = new int[m+1][n+1];
        //matrix count of 2, in col i, from j to k (j<=k) matrix[k+1][i+1] - matrix[j][i+1]
        int[][] matrix2col = new int[m+1][n+1];
        int[][] matrix5col = new int[m+1][n+1];
        for(int i = 0;i<grid.length;i++){
            // System.out.println(Arrays.toString(grid[i]));
            for(int j = 0;j<grid[0].length;j++){
                int count2 = count2(grid[i][j]);
                int count5 = count5(grid[i][j]);
                // System.out.println("grid["+i+"]"+"["+j+"]="+"grid[i][j]"+",count2:"+count2);
                matrix2row[i+1][j+1] = matrix2row[i+1][j] + count2; 
                matrix5row[i+1][j+1] = matrix5row[i+1][j] + count5; 
            }
        }
        for(int j = 0;j<grid[0].length;j++){
            for(int i = 0;i<grid.length;i++){
                int count2 = count2(grid[i][j]);
                int count5 = count5(grid[i][j]);
                matrix2col[i+1][j+1] = matrix2col[i][j+1] + count2;
                matrix5col[i+1][j+1] = matrix5col[i][j+1] + count5;
            }
        }
        //Part 1: move only horizontal 
        //grid[0][0]->grid[0][n-1]
        //grid[1][0]->grid[1][n-1]
        //...
        //grid[m-1][0]->grid[m-1][n-1]
        int ans = 0;
        for(int i = 0;i<m;i++){
            int count2 = matrix2row[i+1][n]-matrix2row[i+1][0];
            int count5 = matrix5row[i+1][n]-matrix5row[i+1][0];
            ans = Math.max(ans, Math.min(count2,count5));
        }
        
        //Part 2: move only vertically
        //grid[0][0]->grid[m-1][0]
        //grid[0][1]->grid[m-1][1]
        //...
        //grid[0][n-1]->grid[m-1][n-1]
        for(int j = 0;j<n;j++){
            int count2 = matrix2col[m][j+1] - matrix2col[0][j+1];
            int count5 = matrix5col[m][j+1] - matrix5col[0][j+1];
            ans = Math.max(ans, Math.min(count2,count5));
        }
        //Find center of + then there are 4 directions
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                
                //up (i,j) to (0,j)
                int count2Up = matrix2col[i+1][j+1] - matrix2col[0][j+1];
                int count5Up = matrix5col[i+1][j+1] - matrix5col[0][j+1];
                //down (i,j) to (m-1,j)
                int count2Down = matrix2col[m][j+1] - matrix2col[i][j+1];
                int count5Down = matrix5col[m][j+1] - matrix5col[i][j+1];
                //left (i,0) to (i,j)
                int count2Left = matrix2row[i+1][j+1]-matrix2row[i+1][0];
                int count5Left = matrix5row[i+1][j+1]-matrix5row[i+1][0];
                //right (i,j) to (i,n-1)
                int count2Right = matrix2row[i+1][n]-matrix2row[i+1][j];
                int count5Right = matrix5row[i+1][n]-matrix5row[i+1][j];
                //3.1 L turn
                ans = Math.max(ans,Math.min(count2Up+count2Right-count2(grid[i][j]),count5Up+count5Right-count5(grid[i][j])));
                //3.2 7 turn
                ans = Math.max(ans,Math.min(count2Up+count2Left-count2(grid[i][j]),count5Up+count5Left-count5(grid[i][j])));
                //3.3 |` turn
                ans = Math.max(ans,Math.min(count2Down+count2Right-count2(grid[i][j]),count5Down+count5Right-count5(grid[i][j])));
                //3.4 J turn
                ans = Math.max(ans,Math.min(count2Down+count2Left-count2(grid[i][j]),count5Down+count5Left-count5(grid[i][j])));
                if(ans == 7){
                    System.out.println(i+" "+j);
                }
            }
        }
        return ans;
    }
    public int count2 (int x){
        int count = 0;
        while(x % 2 == 0){
            count++;
            x = x / 2;
        }
        return count;
    }
    
    public int count5 (int x){
        int count = 0;
        while(x % 5 == 0){
            count++;
            x = x / 5;
        }
        return count;
    }

    @Test
    public void test(){
        int[][] grid = null;

        grid = new int[][]{
            {10},
            {6},
            {15}
        };
        System.out.println(maxTrailingZeros(grid));

        grid = new int[][]{
            {437,230,648,905,744,416},
            {39 ,193,421,344,755,154},
            {480,200,820,226,681,663},
            {658,65 ,689,621,398,608},
            {680,741,889,297,530,547},
            {809,760,975,874,524,717}};

        //grid = new int[][]{{480,200,820,226,681}};
        System.out.println(maxTrailingZeros(grid));
        //6 -> 10 -> 1 -> 6 -> 20 -> 15
        //3,4 -> 3,3 -> 3,2 -> 2,2{2:1,5:0} -> 1,2{2:2,5:1} -> 0,2{2:0,5:1}
        grid = new int[][]{
            {23,17,15,3 ,20},
            {8 ,1 ,20,27,11},
            {9 ,4 ,6 ,2 ,21},
            {40,9 ,1 ,10,6},
            {22,7 ,4 ,5 ,3},
        };

        //grid = new int[][]{{4,1,6,20,15,3,20}};
        System.out.println(maxTrailingZeros(grid));
        grid = new int[][]{
            {4,3,2},
            {7,6,1},
            {8,8,8}
        };
        System.out.println(maxTrailingZeros(grid));

        
    }
}
