package Medium;


import java.util.Arrays;

import org.testng.annotations.Test;

public class _130_SurroundedRegions{
    public void solve(char[][] board) {
        char[][] xBoard = new char[board.length][board[0].length];
        for(int i = 0; i <xBoard.length; i++){
            for(int j = 0; j<xBoard[0].length; j++) {
                if(i==0 || j==0 || i == board.length-1 || j == board[0].length-1)
                    xBoard[i][j] = board[i][j];
                else
                    xBoard[i][j] = 'X';
            }
        }

        for(int i = 1; i <xBoard[0].length-1; i++){
            if(xBoard[0][i] == 'O'){
                rec(board,xBoard,1,i,1);
            }
            if(xBoard[xBoard.length-1][i] == 'O'){
                rec(board,xBoard,board.length-2,i,0);
            }
        }

        for(int i = 1; i <xBoard.length-1; i++){
            if(xBoard[i][0] == 'O'){
                rec(board,xBoard,i,1,3);
            }
            if(xBoard[i][board[0].length-1] == 'O'){
                rec(board,xBoard,i,board[0].length-2,2);
            }
        }

        for(int i = 1; i <xBoard.length-1; i++){
            for(int j = 1; j<xBoard[0].length-1; j++) {
                board[i][j] = xBoard[i][j];
            }
        }
    }

    //dir : 0-top,1-bottom,2-left,3-right
    private void rec(char[][] board, char[][] xBoard, int i, int j, int dir){
        if(i <= 0 || i >= board.length-1 || j <= 0 || j >= board[0].length-1) return;
        boolean hasO = dir>=0;
        if(board[i][j] == 'O' && xBoard[i][j] == 'X') xBoard[i][j] = 'O';
        else return;

        if(dir != 1 &&i-1>=0 && board[i-1][j] == 'O'){
            rec(board,xBoard, i-1,j,0);
        } 
        if(dir != 0 && i+1<board.length && board[i+1][j] == 'O'){
            rec(board,xBoard,i+1,j,1);
        } 
        if(dir != 3 &&j-1>=0 && board[i][j-1] == 'O'){
            rec(board,xBoard,i,j-1,2);
        } 
        if(dir != 2 &&j+1<board[0].length && board[i][j+1] == 'O'){
            rec(board,xBoard,i,j+1,3);
        } 
    }

    @Test
    public void test(){
        char[][] arr = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };

        solve(arr);
        for(char[] row : arr)
            System.out.println(Arrays.toString(row));
    }
}